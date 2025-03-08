import asyncio
import logging
from aiogram import Bot, Dispatcher
from aiogram.types import BotCommand

from config import BOT_TOKEN
from handlers import start, profile, search, random, watch

logging.basicConfig(level=logging.INFO)

bot = Bot(token=BOT_TOKEN)
dp = Dispatcher()

async def set_commands():
    commands = [
        BotCommand(command="/start", description="Registration"),
        BotCommand(command="/profile", description="Profile information"),
        BotCommand(command="/search", description="Search for a movie"),
        BotCommand(command="/random", description="Get a random movie"),
    ]
    await bot.set_my_commands(commands)

async def main():
    dp.include_router(start.router)
    dp.include_router(profile.router)
    dp.include_router(search.router)
    dp.include_router(random.router)
    dp.include_router(watch.router)
    await set_commands()
    await dp.start_polling(bot)

if __name__ == "__main__":
    asyncio.run(main())
