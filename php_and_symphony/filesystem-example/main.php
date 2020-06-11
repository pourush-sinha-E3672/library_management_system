<?php 
   require_once __DIR__ . '/vendor/autoload.php'; 
   use Symfony\Component\Filesystem\Filesystem; 
   use Symfony\Component\Filesystem\Exception\IOExceptionInterface; 
   
   $fs = new Filesystem(); 
   try {
      echo "hi1"; 
      $fs->mkdir('./sample-dir'); 
      $fs->touch('./sample-dir/text.txt'); 
      echo "hi2";
   } catch (IOExceptionInterface $e) { 
      echo "hi3";
      echo $e; 
   } 
?>  
