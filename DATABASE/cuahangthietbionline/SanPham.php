<?php
	class SanPham
	{
		function __construct($id, $tensp, $giasp, $hinhanhsp, $motasp, $idloaisp)
		{
			$this->id = $id;
			$this->tensp = $tensp;
			$this->giasp = $giasp;
			$this->hinhanhsp = $hinhanhsp;
			$this->motasp = $motasp;
			$this->idloaisp = $idloaisp;
		}
	}
?>