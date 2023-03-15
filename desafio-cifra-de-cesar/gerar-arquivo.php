<?php
	require('./config.php');
	$numero_casas = (int)$_POST['numero_casas'];
	$token = $_POST['token'];
	$cifrado = $_POST['cifrado'];
	$resumo_criptografico = sha1($decifrado);
	$decifrado = criptografia::decryptText($cifrado, $numero_casas);
	$_POST['decifrado'] = $decifrado;
	$_POST['resumo_criptografico'] = $resumo_criptografico;
	$_POST['numero_casas'] = (int)$numero_casas;
	$content = json_encode($_POST);

	$abreCria = fopen('files/answer.json', 'a');

	$escreve = fwrite($abreCria, $content);

	fclose($abreCria);
	$retorno = array("sucesso"=>true);
	die (json_encode($retorno));

?>