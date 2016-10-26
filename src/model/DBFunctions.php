<?php

class DBFunctions {
	
	private $db;
	
	function __construct() {
		require_once 'DBConnect.php';
		
		$this->db = new DBConnect();
		$this->db->connect();
	}
	
	function __destruct() {
		
	}
	
	public function storeUser($name, $email, $password) {
		
		$uuid = uniqid('', true);
		$hash = $this->hashSSHA($password);
		$encrypted_password = $hash["encrypted"];
		$salt = $hash["salt"];
		$result = mysql_query(
					"INSERT INTO users (
					  UNIQUE_ID,
					  NAME,
					  EMAIL,
					  ENCRYPTED_PASSWORD,
					  SALT,
					  CREATED_AT) 
					  VALUES(
					  '$uuid',
					  '$name',
					  '$encrypted_password',
					  '$salt',
					   NOW())");
		
		if($resut) {
			$uid = mysql_insert_id();
			$result = mysql_query("SELECT * FROM users WHERE uid = $uid");
			
			return mysql_fetch_array($result);
		} else {
			return false;
		}
	}
	
	public function getUserByEmailAndPassword($email, $password) {
      
      $result = mysql_query("SELECT * FROM users WHERE email = '$email' ") or die(mysql_error());
      $no_of_rows = mysql_num_rows($result);    
      if($no_of_rows > 0) {
         $result =mysql_fetch_array($result);
         $salt = $result['SALT'];
         $encrypted_password = $result['ENCRYPTED_PASSWORD'];
         $hash = $this->checkHashSSHA($salt, $password);
         
         if($encrypted_password == $hash) {
            return $result;
         } else {
            return false;
         }
      }
   
   }
   
   public function isUserExisted($email) {
      
      $result = mysql_query("SELCT email FROM user WHERE email = '$email' ");
      $num_of_rows = mysql_num_rows($result);
      if($num_of_rows > 0) {
         return true;
      } else {
         return false;
      }
   }
   
   public function hashSSHA($password) {
      
      $salt = sha1(rand());
      $salt = substr($salt, 0, 10);
      $encrypted = base64_encode(sha1($password . $salt, true) . $salt);
      $hash = array("salt" => $salt, "encrypted" => $encrypted);
      
      return $hash;
   }
   
   public function checkHashSSHA($salt, $password) {
      
      $hash = base64_encode(sha1($password . $salt, true) . $salt);
      
      return $hash;
   }
   
}
?>