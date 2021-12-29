<?php
	include "connect.php";
	include "LoaiSanPham.php";
	$query = "SELECT * FROM loaisanpham";
	$data = mysqli_query($conn, $query);
	$mangloaisp = array();
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangloaisp, new LoaiSanPham(
			$row['id'],
			$row['tenloaisanpham'],
			$row['hinhanhloaisanpham']));
	}
	echo json_encode($mangloaisp);
?>