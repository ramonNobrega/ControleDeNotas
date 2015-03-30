function HashMap() {
	this.set = function(index,value) {
		this[index] = value;
	};
	this.get = function(index) {
		return this[index];
	};
}

  var regras = new Array();
  function Regra(CAMPO,VALOR,CONDICAO){ 
    this.campo = CAMPO 
    this.valor = VALOR 
    this.condicao = CONDICAO 
  } 
  function validate(ARRAY) {
    var erro = '';
    for (i=0; i<ARRAY.length; i++) {
      if (ARRAY[i].valor==ARRAY[i].condicao) {
         erro += '   ' + ARRAY[i].campo + ' \n';
      }
    }
    regras = new Array();
    if (erro.length>0) {
      alert('Error: \n' + erro + '. Fill in the fields.');
      return false;
    } else {
      return true;
    }
  }
  function toLowerCase(ELEMENTS) {
    ELEMENTS.value = ELEMENTS.value.toLowerCase();
  }
  function toUpperCase(ELEMENTS) {
    ELEMENTS.value = ELEMENTS.value.toUpperCase();
  }
  function toJavaCase(ELEMENTS) {
    ELEMENTS.value = ELEMENTS.value.substring(0,1).toUpperCase() + ELEMENTS.value.substring(1);
  }
  function toDouble(ELEMENTS) {
    var original = ELEMENTS.value;
    if (ELEMENTS.value.indexOf(',')!=-1) {
      ELEMENTS.value = (ELEMENTS.value).replace(".","");
    }
    ELEMENTS.value = (ELEMENTS.value).replace(",",".");
  }
  function today(ELEMENTS) {
    var today = new Date()
    ELEMENTS.value= today.getDate() + '/' + (today.getMonth()+1) + '/' + today.getYear();
  }
  function show(ID) {
    m = document.getElementById(ID).style;
    if (m.display=='none') {
      m.display='block';
    } else {
      m.display='none'; 
    }
  }
  function verificaCpf(x, y) { 
    var numero = x.value;
    var digito = y.value;
    if (numero==null ||
        numero=='' ||
        digito==null || 
        digito=='' || 
        numero==111111111 || 
        numero==222222222 || 
        numero==333333333 || 
        numero==444444444 || 
        numero==555555555 || 
        numero==666666666 || 
        numero==777777777 || 
        numero==888888888 || 
        numero==999999999) { 
      numero="";
      digito="";
      x.focus();
      alert('Digite Corretamente o Cpf do Cliente');
      return false;
    } else { 
      Div_Ini = 100000000;
      Mult_Ini = 10;
      Num_Ini = x.value;
      Acum = 0;
      Acum_Aux = 0; 
      Div_Calc = 0;
      Mult_Calc = 0;  
      V_Digito = 0;
      Resultado = 0;
      for (i = 0; i < 2; i++) { 
        Mult_Calc = Mult_Ini+i;
        Div_Calc  = Div_Ini * ( 9*i+1 );
        Acum_Aux = Num_Ini * ( 9*i+1 )+Acum;
        Acum = 0;
        while (Div_Calc > 0 ) { 
          V_Digito = (Acum_Aux - ( Acum_Aux % Div_Calc ))/Div_Calc;
          Acum = Acum + V_Digito * Mult_Calc;
          Acum_Aux  = Acum_Aux - ( V_Digito * Div_Calc );
          Mult_Calc = Mult_Calc-1;
          if (Mult_Calc < 2) {  
            Mult_Calc = 9;
          }  
          Div_Calc  = Div_Calc / 10;
        }  
        Acum = 11 - (Acum % 11);
        if (Acum > 9) {  
          Acum = 0;
        }  
        Resultado = Resultado + Acum * ( 9*( 1-i ) + 1 );
      }  
      if (Resultado != y.value) { 
        alert('Dï¿½gito CPF incorreto. Verifique CPF do cliente');
        x.focus();  
        return false;
      }  
    } 
    return true;
  } 
function FormatDate(campo,teclapres) {
 var tecla = teclapres.keyCode;
 vr = campo.value;
 vr = vr.replace( ".", "" );
 vr = vr.replace( "-", "" );
 vr = vr.replace( "/", "" );
 vr = vr.replace( "/", "" );
 vr = vr.replace( "/", "" );
 tam = vr.length + 1;
 if ( tecla != 9 && tecla != 8 ){
  if ( tam > 2 && tam < 5 )
   campo.value = vr.substr( 0, tam - 2  ) + '/' + vr.substr( tam - 2, tam );
  if ( tam >= 5 && tam <= 10 )
   campo.value = vr.substr( 0, 2 ) + '/' + vr.substr( 2, 2 ) + '/' + vr.substr( 4, 4 ); 
 }
}
function FormatNumber(campo,tammax,teclapres) {
    var tecla = teclapres.keyCode;
    var vl = String.fromCharCode(teclapres.keyCode);
    vr = campo.value;
    if (vl!='0' && vl!='1' && vl!='2' &&  vl!='3' && vl!='4' && vl!='5' && vl!='6' && vl!='7' && vl!='8' && vl!='9' && vl!='.' && vl!=',') {
      vr = vr.replace(vl, "");
      campo.value = vr;
      return;
    }
}
function FormatValue(campo,tammax,teclapres) {
 var tecla = teclapres.keyCode;
 var vl = String.fromCharCode(teclapres.keyCode);
 vr = campo.value;
        if (vl!='0' && vl!='1' && vl!='2' &&  vl!='3' && vl!='4' && vl!='5' && vl!='6' && vl!='7' && vl!='8' && vl!='9' && vl!='.' && vl!=',') {
          vr = vr.replace(vl, "");
          campo.value = vr;
          return;
        }
        vr = vr.replace( "/", "" );
 vr = vr.replace( "/", "" );
 vr = vr.replace( ".", "" );
 vr = vr.replace( ",", "" );
 vr = vr.replace( ",", "" );
 vr = vr.replace( ",", "" );
 vr = vr.replace( ",", "" );
 vr = vr.replace( ",", "" );
 tam = vr.length;

 if (tam < tammax && tecla != 8){ tam = vr.length + 1 ; }

 if (tecla == 8 ){ tam = tam - 1 ; }
  
 if ( tecla == 8 || tecla >= 48 && tecla <= 57 || tecla >= 96 && tecla <= 105 ){
  if ( tam <= 2 ){ 
    campo.value = vr ; }
   if ( (tam > 2) && (tam <= 5) ){
    campo.value = vr.substr( 0, tam - 2 ) + '.' + vr.substr( tam - 2, tam ) ; }
   if ( (tam >= 6) && (tam <= 8) ){
    campo.value = vr.substr( 0, tam - 5 ) + ',' + vr.substr( tam - 5, 3 ) + '.' + vr.substr( tam - 2, tam ) ; }
   if ( (tam >= 9) && (tam <= 11) ){
    campo.value = vr.substr( 0, tam - 8 ) + ',' + vr.substr( tam - 8, 3 ) + ',' + vr.substr( tam - 5, 3 ) + '.' + vr.substr( tam - 2, tam ) ; }
   if ( (tam >= 12) && (tam <= 14) ){
    campo.value = vr.substr( 0, tam - 11 ) + ',' + vr.substr( tam - 11, 3 ) + ',' + vr.substr( tam - 8, 3 ) + ',' + vr.substr( tam - 5, 3 ) + '.' + vr.substr( tam - 2, tam ) ; }
   if ( (tam >= 15) && (tam <= 17) ){
    campo.value = vr.substr( 0, tam - 14 ) + ',' + vr.substr( tam - 14, 3 ) + ',' + vr.substr( tam - 11, 3 ) + ',' + vr.substr( tam - 8, 3 ) + ',' + vr.substr( tam - 5, 3 ) + '.' + vr.substr( tam - 2, tam ) ;}
 }
}
function isNumber(inputValue) {
  inputStr = inputValue.toString();
  for (var i = 0; i < inputStr.length; i++) {
    var oneChar = inputStr.charAt(i);
    if (i == 0 && oneChar == "-") {
      continue;
    }
    if (oneChar == "." && !oneDecimal) {
      oneDecimal = true;
      continue;
    }
    if (oneChar == "," && !oneDecimal) {
      oneDecimal = true;
      continue;
    }
    if (oneChar < "0" || oneChar > "9") {
      return false;
    }
  }
  return true;
}
function parseNumber(field) {
  oneDecimal = false;
  var inputValue = field.value;
  if (!isNumber(inputValue)) {
    alert('Not a number!');
    field.value = '';
    field.focus();      
    return false;
  }
  return true;
}
function parseDate(field) {
  var DATE = field.value;
  if (DATE==null || DATE=='' || DATE.length==0) {
    return true;
  }
  var begin = DATE.indexOf('/');
  var last = DATE.lastIndexOf('/');
  var dia = DATE.substr(0,begin);
  var mes = DATE.substr((begin+1),((last-begin)-1));
  var ano = DATE.substr((last+1));
  if (!isNumber(dia) || !isNumber(mes) || !isNumber(ano) ) {
    alert('Correct date format: dd/mm/aaaa!');
    field.focus();
    return false;
  }
  if (ano<1 || ano>9999) {
    alert('Invalid Date - check year!');
    field.focus();
    return false;
  } 
  if (mes<1 || mes>12) {
    alert('Invalid Date - check month!');
    field.focus();
    return false;
  } 
  if (mes=='1' || mes=='01' || 
      mes=='5' || mes=='05' || 
      mes=='7' || mes=='07' || 
      mes=='8' || mes=='08' || 
      mes=='10' || 
      mes=='12') {
    if (dia<1 || dia>31) {
      alert('Invalid Date - check day!');
      field.focus();
      return false;
    }
  } else if (mes==2 || mes==02) {
    if (dia<1 || dia>29) {
      alert('Invalid Date - check day!');
      field.focus();
      return false;
    }
  } else if (
      mes=='1' || mes=='01' || 
      mes=='3' || mes=='03' || 
      mes=='4' || mes=='04' || 
      mes=='9' || mes=='09' || 
      mes=='11') {
    if (dia<1 || dia>30) {
      alert('Invalid Date - check day!');
      field.focus();
      return false;
    }
  }
}
function corrige_ponto(X) {
  var original = X.value;
  if (X.value.indexOf(',')!=-1) {
    X.value = (X.value).replace(".","");
  }
  X.value = (X.value).replace(",",".");
}

function FormataData(campo,teclapres) {
 var tecla = teclapres.keyCode;
 vr = campo.value;
 vr = vr.replace( ".", "" );
 vr = vr.replace( "-", "" );
 vr = vr.replace( "/", "" );
 vr = vr.replace( "/", "" );
 vr = vr.replace( "/", "" );
 tam = vr.length + 1;
 if ( tecla != 9 && tecla != 8 ){
  if ( tam > 2 && tam < 5 )
   campo.value = vr.substr( 0, tam - 2  ) + '/' + vr.substr( tam - 2, tam );
  if ( tam >= 5 && tam <= 10 )
   campo.value = vr.substr( 0, 2 ) + '/' + vr.substr( 2, 2 ) + '/' + vr.substr( 4, 4 ); 
 }
}
function FormatValue(campo,tammax,teclapres) {
 var tecla = teclapres.keyCode;
 vr = document.form[campo].value;
 vr = vr.replace( "/", "" );
 vr = vr.replace( "/", "" );
 vr = vr.replace( ",", "" );
 vr = vr.replace( ".", "" );
 vr = vr.replace( ".", "" );
 vr = vr.replace( ".", "" );
 vr = vr.replace( ".", "" );
 tam = vr.length;

 if (tam < tammax && tecla != 8){ tam = vr.length + 1 ; }

 if (tecla == 8 ){ tam = tam - 1 ; }
  
 if ( tecla == 8 || tecla >= 48 && tecla <= 57 || tecla >= 96 && tecla <= 105 ){
  if ( tam <= 2 ){ 
    document.form[campo].value = vr ; }
   if ( (tam > 2) && (tam <= 5) ){
    document.form[campo].value = vr.substr( 0, tam - 2 ) + ',' + vr.substr( tam - 2, tam ) ; }
   if ( (tam >= 6) && (tam <= 8) ){
    document.form[campo].value = vr.substr( 0, tam - 5 ) + '.' + vr.substr( tam - 5, 3 ) + ',' + vr.substr( tam - 2, tam ) ; }
   if ( (tam >= 9) && (tam <= 11) ){
    document.form[campo].value = vr.substr( 0, tam - 8 ) + '.' + vr.substr( tam - 8, 3 ) + '.' + vr.substr( tam - 5, 3 ) + ',' + vr.substr( tam - 2, tam ) ; }
   if ( (tam >= 12) && (tam <= 14) ){
    document.form[campo].value = vr.substr( 0, tam - 11 ) + '.' + vr.substr( tam - 11, 3 ) + '.' + vr.substr( tam - 8, 3 ) + '.' + vr.substr( tam - 5, 3 ) + ',' + vr.substr( tam - 2, tam ) ; }
   if ( (tam >= 15) && (tam <= 17) ){
    document.form[campo].value = vr.substr( 0, tam - 14 ) + '.' + vr.substr( tam - 14, 3 ) + '.' + vr.substr( tam - 11, 3 ) + '.' + vr.substr( tam - 8, 3 ) + '.' + vr.substr( tam - 5, 3 ) + ',' + vr.substr( tam - 2, tam ) ;}
 }
  
 for (var ct = 0; ct < document.form.elements.length; ct++) {
  if (document.form.elements[ct].name == document.form.elements[campo].name) {
   if ( !teclapres.shiftKey && tecla == 9 && document.form[ct+1].name == "senhaConta" && document.applets['tclJava'] ){
    document.applets['tclJava'].setFocus();
   } 
  }
 }
}

function switchOn(tab,contents,topblock,cell) {
  topRow = document.getElementById(topblock);
  tabArray = topRow.childNodes;
  for (var i=0; i<tabArray.length; i++) {
    if (tabArray[i].className != 'tabspacer') {
      tabArray[i].className = 'tab';
    }
  }
  contentsCell = document.getElementById(cell);
  contentsArray = contentsCell.childNodes;
  for (var j=0; j<contentsArray.length; j++) {
    contentsArray[j].className = 'contents';
  }
  document.getElementById(tab).className = 'selectedtab';
  document.getElementById(contents).className = 'selectedcontents';
}

function confirmSubmit(text) {
  if (text==null || text=='') {
    var agree=confirm("Confirma esta Operação?");
  } else {
    var agree=confirm(text);
  }
  if (agree) {
   return true ;
  } else {
   return false ;
 }
}

function confirmSubmit(text, ok, cancel) {
  if (text==null || text=='') {
    text = 'Confirma esta Operação?';
  }  
  if (ok==null || ok=='') {
    ok = 'Ok';
  }  
  if (cancel==null || cancel=='') {
    cancel = 'Cancel';
  }  
  var agree=confirm(text, ok, cancel);
  if (agree) {
   return true ;
  } else {
   return false ;
 }
}

var state = 'hidden';
function showhide(layer_ref) {
  if (state == 'visible') {
    state = 'hidden';
  } else {
    state = 'visible';
  }
  if (document.all) { 
    eval( "document.all." + layer_ref + ".style.visibility = state");
  }
  if (document.layers) { 
    document.layers[layer_ref].visibility = state;
  }
  if (document.getElementById && !document.all) {
    maxwell_smart = document.getElementById(layer_ref);
    maxwell_smart.style.visibility = state;
  }
}

function abremenu(x){
 if (IE) {
 document.all.divinfos[x-1].style.visibility="hidden";
 document.all.divinfos[x-1].style.display='';
 document.all.divinfos[x-1].style.filter="blendTrans(duration=.5)";
 document.all.divinfos[x-1].filters.blendTrans.Apply();
 document.all.divinfos[x-1].style.visibility="visible";
 document.all.divinfos[x-1].filters.blendTrans.Play();
 }
}

function fechamenu(x){
 if (IE) {
 document.all.divinfos[x-1].style.visibility="hidden";
 document.all.divinfos[x-1].style.display='none';
 }
}

var display_url=0
function showmenuie5(e){
  if (navigator.appName.indexOf("Microsoft") < 0) {
    document.getElementById("ie5menu").style.left=e.pageX;
    document.getElementById("ie5menu").style.top=e.pageY; 
  } else {
    document.getElementById("ie5menu").style.left=event.clientX
    document.getElementById("ie5menu").style.top=event.clientY

  }
  document.getElementById("ie5menu").style.visibility="visible"
  return false
}

function hidemenuie5(){
  document.getElementById("ie5menu").style.visibility="hidden"
}

function setCheckField(field, gridCheckFieldName) {
  fields = document.getElementsByName(field.id);
  checkFields = document.getElementsByName(gridCheckFieldName);
  for (i=0;i<fields.length;++ i) {
    if (fields[i]==field) {
      checkFields[i].checked=true;
      break;
    }
  }
}

function showhide2(layer_ref) {
  var state = document.getElementById(layer_ref).style.visibility;
  var display = document.getElementById(layer_ref).style.display;
  if (state == 'visible') {
    state = 'hidden';
    display = 'none';
  } else {
    state = 'visible';
    display = '';
  }
  if (document.all) { 
    eval( "document.all." + layer_ref + ".style.visibility = state");
    eval( "document.all." + layer_ref + ".style.display = display");
  }
  if (document.layers) { 
    document.layers[layer_ref].visibility = state;
  }
  if (document.getElementById && !document.all) {
    maxwell_smart = document.getElementById(layer_ref);
    maxwell_smart.style.visibility = state;
    maxwell_smart.style.display = display;
  }
}