<?php

	class criptografia
	{
		public static function decryptText($text, $casas){
			$nr_letra;
			$calculo;
			$nr_nova_letra;
			$nr_casas = (int)$casas;
			$nr_letras_alfabeto = 26;
			$nova_letra;
			$texto_real = "";

			for ($i=0; $i < strlen($text) + 1; $i++) { 
				if (substr($text, $i, 1) == ' '){
					$texto_real .= ' ';
				}else{
					$nr_letra = self::getLetter(substr($text, $i, 1), 1);
					if (is_numeric($nr_letra)){
						if ($nr_letra < $nr_casas + 1){
							$nr_nova_letra = $nr_letras_alfabeto - ($nr_casas - $nr_letra);
						}else{
							$nr_nova_letra = $nr_letra - $nr_casas;
						}
						$nova_letra = self::getLetter($nr_nova_letra, 2);
					}else{
						$nova_letra = $nr_letra;
					}
					$texto_real .= $nova_letra;
				}
			}
				return $texto_real;	
		}

		public static function getUniqIdSha1(){
			return sha1(uniqid());
		}
		
		private static function getLetter($l, $t){
			$n = 0;
				foreach (range('a', 'z') as $letra) {
					$final = false;
					$n += 1;
					if($t == 1){
						if ($letra == $l){
							break;	
						}
					}else if($t == 2){
						if($n == $l){
							$n = $letra;
							break;	
						}
					}
					$final = true;
				}
				if ($final == true){
					return $l;
				}else{
					return $n;
				}
		}
		
	}

?>