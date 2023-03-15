$(function(){
	var token = "3dd186c75ff25e695a85bcb95cfe988fe1ec0de7";//7
	$('#getText').click(function(e){
		$.ajax({
				url: 'https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token='+token,
				method: 'get',
				//contentType: "multipart/form-data",
				dataType: 'json',
				data: {},
				beforeSend: function(){
					console.log('carregando');
				},
				success: function(data){
						gerarArquivo(data);
					}
				})
			e.preventDefault();
			
	})

	function gerarArquivo(base){
		$.ajax({
				url: 'gerar-arquivo.php',
				method: 'post',
				dataType: 'json',
				data: base,
				success: function(data){
					if (data.sucesso == true){
						$('.form-group').prepend('<div style="margin: 0 auto; text-align: center; line-height: 30px; font-size: 14px; width: 100%; height: 30px; background-color: #28a745; color: white; border: 1px solid green;"><i class="fa fa-check"></i> Arquivo gerado com sucesso!</div>');
					}
				}
		})
	}
	 //$('body').on('submit', 'form', function(e){
	 //	e.preventDefault();
	 //	var form = new FormData();
	 //	var img = $('#answer');
	 //	alert(img[0].files[0])
	 //	form.append('answer', img[0].files[0], "answer");
	 //	alert(form.entries())
	 //	alert('hi');
	 //	$.ajax({
	 //		url: 'https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token='+token,
	 //		method: 'post',
	 //		contentType: "multipart/form-data",
	 //		processData: false,
	 //		data: form,
	 //		success: function(data){
	 //			alert('hi');
	 //			console.log(data);
	 //					$('.form-group').prepend('<div style="margin: 0 auto; text-align: center; line-height: 30px; font-size: 14px; width: 100%; height: 30px; background-color: #28a745; color: white; border: 1px solid green;"><i class="fa fa-check"></i>'+data+'</div>');
	 //		}
	 //	})
	 //})
}) //