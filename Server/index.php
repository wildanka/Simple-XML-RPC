<?php
/*
* First, we define some PHP functions to expose via
* XML-RPC. Any functions that will be called by a
* XML-RPC client need to take three parameters:
* The first parameter passed is the name of the
* XML-RPC method called, the second is an array
* Containing the parameters sent by the client, and
* The third is any data sent in the app_data
* parameter of the xmlrpc_server_call_method()
* function (see below).
*/

/* kenang2an
function uptime_func($method_name, $params, $app_data)
{
return "hohoho";
}
function greeting_func($method_name, $params, $app_data)
{
$name = $params[0];
return "Hello, $name. How are you today?";
}
*/
function username_func($method_name, $params, $app_data)
{
	$no_handphone = $params[0];
	return $no_handphone;
}

function chat_func($method_name, $params, $app_data)
{
	$chat = $params[1];
	return $chat;
}

function waktu_func($method_name, $params, $app_data)
{
	$waktu = $params[2];
	return $waktu;
}
function get_penerima($method_name, $params, $app_data)
{
	$penerima = $params[3];
	return $penerima;
}
/*
* This creates a server and sets a handle for the
* server in the variable $xmlrpc_server
*/
$xmlrpc_server = xmlrpc_server_create();
/*
* xmlrpc_server_register_method() registers a PHP
* function as an XML-RPC method. It takes three
* parameters:
* The first is the handle of a server created with
* xmlrpc_server_create(), the second is the name to
* register the server under (this is what needs to
* be in the <methodName> of a request for this
* method), and the third is the name of the PHP
* function to register.
*/
xmlrpc_server_register_method($xmlrpc_server, "greeting", "greeting_func");
xmlrpc_server_register_method($xmlrpc_server, "uptime", "uptime_func");
xmlrpc_server_register_method($xmlrpc_server, "username", "username_func");
xmlrpc_server_register_method($xmlrpc_server, "timestamp", "waktu_func");
xmlrpc_server_register_method($xmlrpc_server, "chat", "chat_func");
xmlrpc_server_register_method($xmlrpc_server, "penerima", "get_penerima");
/*
* When an XML-RPC request is sent to this script, it
* can be found in the raw post data.
*/
$request_xml = $HTTP_RAW_POST_DATA;
/*
* The xmlrpc_server_call_method() sends a request to
* the server and returns the response XML. In this case,
* it sends the raw post data we got before. It requires
* 3 arguments:
* The first is the handle of a server created with
* xmlrpc_server_create(), the second is a string containing
* an XML-RPC request, and the third is for application data.
* Whatever is passed into the third parameter of this function
* is passed as the third paramater of the PHP function that the
* request is asking for.
*/
$response = xmlrpc_server_call_method($xmlrpc_server, $request_xml, '');
// Now we print the response for the client to read.
print $response;
/*
* This method frees the resources for the server specified
* It takes one argument, a handle of a server created with
* xmlrpc_server_create().
*/
xmlrpc_server_destroy($xmlrpc_server);
?>
