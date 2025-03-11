from dotenv import load_dotenv
import os

load_dotenv()
BOT_TOKEN = os.getenv("BOT_TOKEN")
API_GATEWAY_URL = os.getenv("API_GATEWAY_URL")