
# Telegram Bot

This project implements a Telegram bot for searching and watching movies, as well as viewing user profiles.

## Features
- /search command to look for a specific movie.
- /random command to retrieve a random movie suggestion.
- /profile command to display Telegram user info.
- Direct playback of available movies via inline callbacks.

## Requirements
- Python 3.8+
- `pip` for dependency management
- Aiogram and Requests:


- A valid Telegram Bot API token

## Setup
1. Clone or download this repository.
2. Install the required dependencies.
3. Set the `API_GATEWAY_URL` environment variable.
4. Create and configure a Telegram bot through BotFather to obtain your bot token.
5. Customize the bot code if needed.

## Usage
1. Run the bot:


2. Interact with your bot in Telegram:
   - Use `/search` to look for a movie.
   - Use `/random` for a random recommendation.
   - Use `/profile` to display user details.

## Project Structure
- `telegram-bot/handlers/watch.py` handles the "/watch" functionality.
- `telegram-bot/handlers/profile.py` manages the "/profile" command.
- `telegram-bot/handlers/random.py` responds to "/random".
- `telegram-bot/handlers/search.py` processes the "/search" command.

## License
This project is licensed under the MIT License.