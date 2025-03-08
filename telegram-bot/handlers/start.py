from aiogram import Router, F
from aiogram.types import Message
import requests
from config import API_GATEWAY_URL

router = Router()

@router.message(F.text.lower() == "/start")
async def start_cmd(message: Message):
    user_data = {
        "telegramId": message.from_user.id,
        "username": message.from_user.username or "No",
    }

    response_get = requests.get(f"{API_GATEWAY_URL}/api/users/get/{user_data['telegramId']}")

    if response_get.status_code == 200:
        await message.answer("✅ Вы зарегистрированы. Введите /profile для просмотра профиля.")
    else:
        response = requests.post(f"{API_GATEWAY_URL}/api/users/register", json=user_data)

        if response.status_code == 200:
            await message.answer("✅ Вы зарегистрированы! Введите /profile для просмотра профиля.")
        else:
            await message.answer("❌ Ошибка регистрации, попробуйте позже.")
