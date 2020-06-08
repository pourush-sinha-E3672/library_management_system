<?php
/**
 * Created by IntelliJ IDEA.
 * User: pourush.sinha
 * Date: 16/08/18
 * Time: 12:40 PM
 */

define("MINSIZE", 50);

echo MINSIZE;
echo constant("MINSIZE");

$a = 42;
$b = 20;

$c = $a + $b;
echo "Addtion Operation Result: $c \n";

$c = $a - $b;
echo "Substraction Operation Result: $c \n";

$c = $a * $b;
echo "Multiplication Operation Result: $c \n";

$c = $a / $b;
echo "Division Operation Result: $c \n";

$c = $a % $b;
echo "Modulus Operation Result: $c \n";

$c = $a++;
echo "Increment Operation Result: $c \n";

$c = $a--;
echo "Decrement Operation Result: $c \n";

$a = 42;
$b = 20;

if( $a == $b ) {
    echo "TEST1 : a is equal to b\n";
}else {
    echo "TEST1 : a is not equal to b\n";
}

if( $a > $b ) {
    echo "TEST2 : a is greater than  b\n";
}else {
    echo "TEST2 : a is not greater than b\n";
}

if( $a < $b ) {
    echo "TEST3 : a is less than  b\n";
}else {
    echo "TEST3 : a is not less than b\n";
}

if( $a != $b ) {
    echo "TEST4 : a is not equal to b\n";
}else {
    echo "TEST4 : a is equal to b\n";
}

if( $a >= $b ) {
    echo "TEST5 : a is either greater than or equal to b\n";
}else {
    echo "TEST5 : a is neither greater than nor equal to b\n";
}

if( $a <= $b ) {
    echo "TEST6 : a is either less than or equal to b\n";
}else {
    echo "TEST6 : a is neither less than nor equal to b\n";
}


$d = date("D");



if ($d == "Fri")
    echo "Have a nice weekend!";

else
    echo "Have a nice day!";

$array = array( 1, 2, 3, 4, 5);

foreach( $array as $value ) {
    echo "Value is $value \n";
    if( $value == 3 )break;
}

foreach( $array as $value ) {
    if( $value == 3 )continue;
    echo "continue check Value is $value \n";

}


$marks = array(
    "mohammad" => array (
        "physics" => 35,
        "maths" => 30,
        "chemistry" => 39
    ),

    "qadir" => array (
        "physics" => 30,
        "maths" => 32,
        "chemistry" => 29
    ),

    "zara" => array (
        "physics" => 31,
        "maths" => 22,
        "chemistry" => 39
    )
);

/* Accessing multi-dimensional array values */
echo "Marks for mohammad in physics : \n" ;
echo $marks['mohammad']['physics'] . "\n";

echo "Marks for qadir in maths : \n";
echo $marks['qadir']['maths'] . "\n";

echo "Marks for zara in chemistry : \n" ;
echo $marks['zara']['chemistry'] . "\n";
$dbhost = 'localhost:3036';
$dbuser = 'root';
$dbpass = '';
$conn = mysql_connect($dbhost, $dbuser, $dbpass);

if(! $conn ) {
    die('Could not connect: ' . mysql_error());
}

echo 'Connected successfully';
mysql_close($conn);
?>