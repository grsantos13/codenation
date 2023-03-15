<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="CSS/estilos.css" />
        <link rel="stylesheet" href="CSS/all.min.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Desafio</title>
    </head>
    <body>
        <header>
            <div class="desafio"><i class="far fa-lightbulb" style="color: yellow; font-size: 40px;"></i><p>DESAFIO CODENATION!</p></div>
        </header>
        <div class="header-border"></div>

        <form method="POST" action="<?php echo API_ANSWER_URL; ?>" enctype="multipart/form-data" id="form-envio">
        	<div class="form-group">
	        	<label>Arquivo Answer.json:</label>
	        	<div class="input-types">
		        	<input type="file" name="answer" id="answer">
		        	<input type="submit" name="submeter" value="Submeter" id="submeter">
					<a href="?gerarArquivo" id="getText">Gerar Arquivo</a>
		        	<div class="clear"></div>
	        	</div>
	        </div>
        </form>

        <script type="text/javascript" src="js/jquery.js"></script>
  	<script type="text/javascript" src="js/ajax.js"></script>
    </body>
</html>