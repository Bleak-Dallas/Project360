<?php

class DBConnect {

	function __construct() {
		
	}
	
	function __destruct() {
		
	}
	
	public function connect() {
		require_once 'config.php';
		
		$conn = mysql_connect(DB_HOST, DB_USER, DB_PASSWORD) or die(mysql_error());
		
		mysql_select_db(DB_DATABASE) or die(mysql_error());
		
		return $conn;
	}
	
	public function close() {
		mysql_close();
	}
	
}

?>