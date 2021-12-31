<?php
	include "connect.php";
	include "SanPham.php";
	$page = $_GET['page'];
	$idloaisp = $_POST['idloaisp'];
	$count = 5;
	$offset = ($page - 1) * $count;
	$query = "SELECT * FROM sanpham WHERE idloaisanpham = $idloaisp LIMIT $offset, $count";
	$data = mysqli_query($conn, $query);
	$mangsp = array();
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangsp, new SanPham(
			$row['id'],
			$row['tensanpham'],
			$row['giasanpham'],
			$row['hinhanhsanpham'],
			$row['motasanpham'],
			$row['idloaisanpham']));
	}
	echo json_encode($mangsp);
?>