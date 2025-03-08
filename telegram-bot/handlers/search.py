from aiogram import Router, F
from aiogram.types import Message, InlineKeyboardMarkup, InlineKeyboardButton
from aiogram.types import ReplyKeyboardMarkup, KeyboardButton
from aiogram.fsm.state import State, StatesGroup
from aiogram.fsm.context import FSMContext
import requests
from config import API_GATEWAY_URL

router = Router()

class SearchMovieState(StatesGroup):
    waiting_for_title = State()

@router.message(F.text == "/search")
async def start_search(message: Message, state: FSMContext):
    await message.answer("📽 Введите название фильма:")
    await state.set_state(SearchMovieState.waiting_for_title)

@router.message(SearchMovieState.waiting_for_title)
async def send_movie(message: Message, state: FSMContext):
    title = message.text.strip()

    response = requests.get(f"{API_GATEWAY_URL}/api/movies/get?title={title}")

    if response.status_code == 200:
        try:
            movie_data = response.json()

            required_keys = {"title", "genre", "director", "year", "plot", "poster", "imdbRating"}
            if not all(key in movie_data for key in required_keys):
                raise KeyError("Не хватает ключей в API-ответе.")

            keyboard = InlineKeyboardMarkup(
                inline_keyboard=[
                    [InlineKeyboardButton(text="🎥 Смотреть", callback_data=f"watch_movie:{movie_data['title']}")]
                ]
            )

            await message.answer_photo(
                photo=movie_data["poster"],
                caption=(
                    f"*{movie_data['title']}*\n\n"
                    f"🎬 *Жанр:* {movie_data['genre']}\n"
                    f"👤 *Режиссер:* {movie_data['director']}\n"
                    f"⭐ *IMDb Рейтинг:* {movie_data['imdbRating']}\n"
                    f"📝 *Описание:* {movie_data['plot']}\n"
                    f"📅 *Год:* {movie_data['year']}"
                ),
                parse_mode="Markdown",
                reply_markup=keyboard
            )

        except Exception as e:
            await message.answer(f"❌ Ошибка обработки данных: {e}")

    else:
        response = requests.get(f"{API_GATEWAY_URL}/api/movies/get/list?title={title}")

        if response.status_code == 200:
            movies = response.json()

            if not movies:
                await message.answer("❌ Фильм не найден.")
                return

            text = "🔎 *Результаты поиска:*\n\n"
            buttons = []

            for movie in movies[:5]:
                if not all(key in movie for key in ["id", "title", "year", "imdbRating", "genre"]):
                    continue

                text += (
                    f"🎬 *{movie['title']}* ({movie['year']})\n"
                    f"⭐ *Рейтинг:* {movie['imdbRating']}\n"
                    f"🎭 *Жанр:* {movie['genre']}\n"
                    f"➖➖➖➖➖➖➖➖➖➖\n"
                )

                buttons.append([KeyboardButton(text=f"Смотреть {movie['title']}")])

            keyboard = ReplyKeyboardMarkup(keyboard=buttons, resize_keyboard=True)

            await message.answer(
                text,
                parse_mode="Markdown",
                reply_markup=keyboard
            )

        else:
            await message.answer("❌ Фильм не найден.")

    await state.clear()


