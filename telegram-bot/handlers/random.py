from aiogram import Router, F
from aiogram.types import Message, InlineKeyboardMarkup, InlineKeyboardButton
import requests
from config import API_GATEWAY_URL

router = Router()

@router.message(F.text.lower() == "/random")
async def random_movie(message: Message):
    response = requests.get(f"{API_GATEWAY_URL}/api/movies/random")

    if response.status_code == 200:
        movie_data = response.json()

        keyboard = InlineKeyboardMarkup(
            inline_keyboard=[
                [InlineKeyboardButton(text="🎥 Смотреть", callback_data=f"watch_movie:{movie_data['title']}")]
            ]
        )

        await message.answer_photo(
            photo=movie_data["poster"],
            caption=f"*{movie_data['title']}*\n\n"
                    f"🎬 *Жанр:* {movie_data['genre']}\n"
                    f"👤 *Режиссер:* {movie_data['director']}\n"
                    f"⭐ *IMDb Рейтинг:* {movie_data['imdbRating']}\n"
                    f"📝 *Описание:* {movie_data['plot']}\n"
                    f"📅 *Год:* {movie_data['year']}",
            parse_mode="Markdown",
            reply_markup=keyboard
        )
    else:
        await message.answer("❌ Фильм не найден.")

