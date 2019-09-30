import requests
from pprint import pprint
url = "https://api.telegram.org/botXXXXX/{}"
r = requests.get(url.format('getUpdates')).json()
r = r['result']

for message in r:
  chat_id = message['message']['chat']['id']
  if message['message'].get('text') == '/start':
    params = {'text':'Hello World', 'chat_id':chat_id}
    r2 = requests.get(url.format('sendMessage'), params)
    pprint(r2.json())

