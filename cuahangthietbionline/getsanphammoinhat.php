<?php
	include "connect.php";
	include "SanPham.php";
	$query = "SELECT * FROM sanpham ORDER BY ID DESC LIMIT 6";
	$data = mysqli_query($conn, $query);
	$mangspmoinhat = array();
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangspmoinhat, new SanPham(
			$row['id'],
			$row['tensanpham'],
			$row['giasanpham'],
			$row['hinhanhsanpham'],
			$row['motasanpham'],
			$row['idloaisanpham']));
	}
	echo json_encode($mangspmoinhat);
?>