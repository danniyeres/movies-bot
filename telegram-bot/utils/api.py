import requests
from config import API_GATEWAY_URL

def register_user(user_data):
    return requests.post(f"{API_GATEWAY_URL}/api/users/register", json=user_data)

def get_user_profile(user_id):
    return requests.get(f"{API_GATEWAY_URL}/api/users/{user_id}")

def get_movie_file(title):
    return requests.get(f"{API_GATEWAY_URL}/api/movies/get?title={title}")
