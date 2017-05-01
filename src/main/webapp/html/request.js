/*
 * examples on how to use the rest api with javascript
 * 
 * */
//get parameters from the url request
var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;
    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};


var word = getUrlParameter('word');
var lang = getUrlParameter('lang');
var num = getUrlParameter('num');

request1 = 'http://localhost:9000/akademiWolof/gaggantikaay/baat?word='+word+'&'+'lang='+lang; 
request2 = 'http://localhost:9000/akademiWolof/gaggantikaay/baatlim?word='+word+'&'+'lang='+lang+'&'+'num='+num;

//send request to the db 
$(function() {
	$.when( $.ajax(request1),$.ajax(request2)).then(
			function(resp1, resp2){ //success
				
				makeUL(resp2[0]);
				makeWord(resp1[0]);
			}, 
			function(err){ //error
				console.log(err);
			});
		});

//add the list of words that are before and after the requested word, in the page.
function makeUL(array) {
	
	var pathname = window.location.pathname; // Returns path only
	
	for(var i = 0; i < array.length; i++) {		
		if(array[i].toUpperCase() === word.toUpperCase()){
			url = "<li class='selected'>"+makeURL(array[i])+"</li>";
		}else
			url = "<li>"+makeURL(array[i])+"</li>"; 
		
		$('#wordList ul').append(url);
	 }
}


function makeURL(value) {
	var lang="wo";
	var pathname = window.location.pathname; // Returns path only
	return "<a href='"+pathname+"?word="+value+"&lang="+lang+'&'+'num='+num+"'>"+value+"</a>"; 
}

function makeWord(word){
	$('#word').append("Word: " );
	$('#word').append("<p>"+word.word+"<p/><br/>" );
	
	if(word.wordType != null && word.wordType.type != ""){
		$('#word').append("WordType: " );
		$('#word').append("<p>"+word.wordType.type+"<p/><br/>" );
	}
	root = word.root;
	if(root.length > 0){
		$('#word').append("root <br/>" );
		for(var i in root){
			index = parseInt(i)+1;
			$('#word').append("<p>"+index+"."+root[i].word+"<p/><br/>" );
		}
	}
	definitions = word.definition;
	if(definitions.length > 0){
		$('#word').append("Definition: <br/>" );
		for(var i in definitions){
			index = parseInt(i)+1;
			$('#word').append("<p>"+index+"."+definitions[i].definition+"<p/><br/>" );
			
			//examples for i definition
			examples = definitions[i].examples;
			if(examples != null && examples.length > 0){
				$('#word').append("Examples: <br/>" );
				for(var y in examples){
					index = parseInt(y)+1;
					$('#word').append("<p>"+index+"."+examples[y].example+"<p/><br/>" );
				}
			}
		}	
	}
	
	synonyms = word.synonyms;
	if(synonyms.length > 0){
		$('#word').append("Synonyms: <br/>" );
		for(var i in synonyms){
			index = parseInt(i)+1;
			$('#word').append("<p>"+index+"."+makeURL(synonyms[i].word)+"<p/><br/>" );
		}
	}
	
	antonyms = word.antonyms;
	if(antonyms.length > 0){
		$('#word').append("Antonyms: <br/>" );
		for(var i in antonyms){
			index = parseInt(i)+1;
			$('#word').append("<p>"+index+"."+makeURL(antonyms[i].word)+"<p/><br/>" );
		}
	}
	
	derivated = word.derivated;
	if(derivated.length > 0){
		$('#word').append("Derivated: <br/>" );
		for(var i in derivated){
			index = parseInt(i)+1;
			$('#word').append("<p>"+index+"."+makeURL(derivated[i].word)+"<p/><br/>" );
		}	
	}
	
	seeAlso = word.seeAlso;
	if(seeAlso.length > 0){
		$('#word').append("see Also: <br/>" );
		for(var i in seeAlso){
			index = parseInt(i)+1;
			$('#word').append("<p>"+index+"."+makeURL(seeAlso[i].word)	+"<p/><br/>" );
		}
	}
	
	fr = word.woFr;
	if(fr.length > 0){
		$('#word').append("Wu faraas: <br/>" );
		for(var i in fr){
			index = parseInt(i)+1;
			$('#word').append("<p>"+index+"."+fr[i].word+"<p/><br/>" );
		}
	}
	
	en = word.woEn;
	if(en.length > 0){
		$('#word').append("Wu angalteer: <br/>" );
		for(var i in en){
			index = i+1;
			$('#word').append("<p>"+index+"."+en[i].word+"<p/><br/>" );
		}
	}
	
	ar = word.woAr;
	if(ar.length > 0){
		$('#word').append("Araab: <br/>" );
		for(var i in ar){
			index = parseInt(i)+1;
			$('#word').append("<p>"+index+"."+ar[i].word+"<p/><br/>" );
		}
	}
}
