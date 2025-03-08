from aiogram import Router, F
from aiogram.types import Message
import requests
from config import API_GATEWAY_URL

router = Router()

@router.message(F.text.lower() == "/profile")
async def get_profile(message: Message):
    user_id = message.from_user.id
    response = requests.get(f"{API_GATEWAY_URL}/api/users/get/{user_id}")

    if response.status_code == 200:
        user = response.json()
        msg = (f"👤 Ваш профиль:\n"
               f"🆔 ID: {user['telegramId']}\n"
               f"📛 Username: {user['username']}\n"
               f"🕐 Дата регистрации: {user['registeredAt']}")
        await message.answer(msg)
    else:
        await message.answer("❌ Профиль не найден. Пройдите /start для регистрации.")
