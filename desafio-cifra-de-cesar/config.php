 <?php

	session_start();
	date_default_timezone_set('America/Sao_Paulo');
	$autoload = function($class){
		if ($class == 'Email'){
			include('class/phpmailer/PHPMailerAutoLoad.php');
		}
		include('class/'.$class.'.php');
	};
	spl_autoload_register($autoload);

	define('TOKEN', '3dd186c75ff25e695a85bcb95cfe988fe1ec0de7');
	define('API_ANSWER_URL', 'https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token='.TOKEN);
	define('API_DATA_URL', 'https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token='.TOKEN);
?>