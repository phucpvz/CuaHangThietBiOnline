<?php
	include "connect.php";
	$json = $_POST['json'];
	$data = json_decode($json, true);
	foreach ($data as $value) {
		$madonhang = $value['madonhang'];
		$masanpham = $value['masanpham'];
		$soluongsanpham = $value['soluongsanpham'];
		$tongtiensanpham = $value['tongtiensanpham'];
		$query = "INSERT INTO chitietdonhang (madonhang, masanpham, soluongsanpham, tongtiensanpham) VALUES ($madonhang, $masanpham, $soluongsanpham, $tongtiensanpham)";
		$result = mysqli_query($conn, $query);
	}
	if ($result) {
		echo "1";
	}
	else {
		echo "0";
	}
?>