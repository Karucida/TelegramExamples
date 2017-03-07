<?php
$token="XXXXX";
$url='https://api.telegram.org/bot'.$token.'/';

$request=json_decode(file_get_contents($url.'getUpdates'),true);

foreach($request['result'] as $message){
	$chat_id=$message['message']['chat']['id'];

	if($message['message']['text']=='/start'){
		$text=urlencode('Hello World');
		echo file_get_contents($url.'sendMessage?chat_id='.$chat_id.'&text='.$text);
	}
} ?>
