
from aiogram import Router, F
from aiogram.types import CallbackQuery, Message, ReplyKeyboardRemove
import requests
from config import API_GATEWAY_URL

router = Router()

@router.callback_query(F.data.startswith("watch_movie:"))
async def watch_movie_callback(call: CallbackQuery):
    title = call.data.split(":")[1]
    response = requests.get(f"{API_GATEWAY_URL}/api/movies/get?title={title}")

    if response.status_code == 200:

        movie_data = response.json()
        file_id = movie_data.get("fileId")

        if not file_id or file_id == "N/A":
            await call.message.answer("❌ фильмы еше нет.")
        else:
            await call.message.answer_video(
                video = movie_data["fileId"],
                caption = f"🎬 {title}",
            )
    else:
        await call.message.answer("❌ Не удалось загрузить фильм.")

    await call.answer()





@router.message(F.text.startswith("Смотреть "))
async def watch_movie (message: Message):

    title = message.text.split("Смотреть ")[1]
    response = requests.get(f"{API_GATEWAY_URL}/api/movies/get?title={title}")

    if response.status_code == 200:

        movie_data = response.json()
        file_id = movie_data.get("fileId")

        if not file_id or file_id == "N/A":
            await message.answer("❌ фильмы еше нет.")
        else:
            await message.answer_video(
                video = movie_data["fileId"],
                caption = f"🎬 {title}",
                reply_markup=ReplyKeyboardRemove()
            )
    else:
        await message.answer("❌ Не удалось загрузить фильм.", reply_markup=ReplyKeyboardRemove())
