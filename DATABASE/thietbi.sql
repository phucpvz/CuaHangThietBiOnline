-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 29, 2021 lúc 08:09 PM
-- Phiên bản máy phục vụ: 10.4.17-MariaDB
-- Phiên bản PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `thietbi`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `id` int(11) NOT NULL,
  `tenloaisanpham` varchar(200) NOT NULL,
  `hinhanhloaisanpham` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `loaisanpham`
--

INSERT INTO `loaisanpham` (`id`, `tenloaisanpham`, `hinhanhloaisanpham`) VALUES
(1, 'Điện thoại', 'https://png.pngtree.com/element_our/20190602/ourmid/pngtree-hand-drawn-smartphone-illustration-image_1401996.jpg'),
(2, 'Laptop', 'https://cdn.picpng.com/notebook/notebook-computer-laptop-79740.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `tensanpham` varchar(200) NOT NULL,
  `giasanpham` int(15) NOT NULL,
  `hinhanhsanpham` varchar(200) NOT NULL,
  `motasanpham` varchar(10000) NOT NULL,
  `idloaisanpham` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`id`, `tensanpham`, `giasanpham`, `hinhanhsanpham`, `motasanpham`, `idloaisanpham`) VALUES
(1, 'Điện thoại iPhone 7 Plus 128GB', 3430000, 'https://file.hstatic.net/1000238589/file/600_iphone_7_plus_pink_800x800_1_13d94f47b9194d59aa7f8303ebda41b7_grande.jpg', 'Màn hình IPhone 7 Plus 128GB\r\n\r\nố vàng    \r\nỐ đen   \r\nSọc ngang   \r\nNhiễu   \r\nCảm ứng, giật, lag   \r\nTrắng xóa   \r\nKhông tự điều chỉnh độ sáng   \r\nBóng mờ   \r\nNhòe màu   \r\nNhiễm từ   \r\nNhấp nháy, hình ảnh không ổn định   \r\nBể màn hình   \r\nLiệt cảm ứng   \r\nNguồn IPhone 7 Plus 128GB\r\n\r\nĐiện thoại bị treo logo\r\nTự động tắt nguồn hoặc khởi động lại máy   \r\nHư nút nguồn   \r\nPin IPhone 7 Plus 128GB\r\n\r\nSạc không vào pin   \r\nNhanh hết pin   \r\nPin ảo   \r\nPin bị phù   \r\nChân sạc IPhone 7 Plus 128GB\r\n\r\nSạc không vào pin   \r\nÂm thanh IPhone 7 Plus 128GB\r\n\r\nLoa rè   \r\nMất tiếng   \r\nHư loa trong, loa ngoài   \r\nMất rung chuông   \r\nHư nút âm thanh   \r\nHư jack cắm tai nghe   ', 1),
(2, 'Điện Thoại Vsmart Joy 4 (4GB/64GB) - New Seal', 3200000, 'https://hungthinhhitech.vn/uploads/product/DIEN_THOAI/VSMART/in_Thoi_Vsmart_Joy_4_1.jpg', 'GIÁ THỊ TRƯỜNG : 3.550.000 VND\r\nTÌNH TRẠNG : NEW SEAL\r\nBẢO HÀNH : 18 THÁNG (HÀNG NEW SEAL)\r\nMÀU SẮC : TRẮNG NGỌC TRAI\r\nChip set: Snapdragon 665 8 nhân\r\nChip đồ họa (GPU): Adreno 610\r\nTốc độ CPU: 4 nhân 2.0 GHz & 4 nhân 1.8 GHz\r\nCamera trước: 13MP\r\nCamera sau: Chính 16 MP & Phụ 8 MP, 2 MP, 2 MP\r\nKích thước màn hình: 6.53 inch\r\nLoại pin: Pin chuẩn Li-Po\r\nCổng sạc: USB Type-C\r\nRAM: 4GB\r\nROM: 64GB\r\nĐộ phân giải: Full HD+ (1080 x 2340 Pixels)\r\nTính năng camera: Trôi nhanh thời gian (Time Lapse), A.I Camera, Xoá phông, Làm đẹp, Góc rộng (Wide), Siêu cận (Macro), Ban đêm (Night Mode), Tự động lấy nét (AF), HDR, Chuyên nghiệp (Pro).', 1),
(3, 'Laptop Lenovo Thinkpad X1 Carbon Gen 3 i7-5600U, Ram 8GB, SSD 256 GB, 14 Inch Full HD IPS', 12500000, 'https://hungthinhhitech.vn/uploads/product/LAPTOP/LENOVO/Lenovo_Thinkpad_X1_Carbon_Gen_3_i7_5600U_1.jpg', 'TÌNH TRẠNG : ĐÃ QUA SỬ DỤNG\r\nBẢO HÀNH : 12 THÁNG (LIKE NEW 99%)\r\nCPU Intel® Core™ i7-5600U CPU 4×2.6Ghz, (4M Cache, up to 3.2 GHz)\r\nRAM 8GB DDR3L 1600MHz\r\nỔ cứng SSD 256GB (SATAIII + PCIe 2.0 4x)\r\nCard đồ họa Intel® HD Graphics\r\nMàn hình 14.1″ LED-Backlit HD Anti-Glare Matte Display FHD 1920×1080\r\nCổng giao tiếp 2 x USB 3.0 (1 with AOU), Audio / Mic Combo OneLink Dock, HDMI, MiniDP, Ethernet ext. port\r\nPin 4 Cell\r\nTrọng lượng 1.7 kg', 2),
(4, 'Laptop Lenovo ThinkPad X1 Carbon Yoga Gen 3 Core i7-8650U, Ram 16GB, 512GB SSD, 14.0 Inch FHD TouchScreen', 20500000, 'https://hungthinhhitech.vn/uploads/product/LAPTOP/LENOVO/Laptop_Lenovo_ThinkPad_X1_Carbon_Yoga_Gen_3_1.jpeg', 'TÌNH TRẠNG : ĐÃ QUA SỬ DỤNG\r\nBẢO HÀNH : 12 THÁNG (LIKE NEW 99%)\r\nCPU Core i7-8650U 1.9Ghz – 4.2Ghz with Turbo boost , 8Mb Cache\r\nRAM LPDDR3 2133MHz 16GB\r\nVGA Intel® UHD Graphics 620\r\nSSD 512GB SSD M.2 Sata PCle\r\nMàn hình 14.0 Inch FHD Touch (1920x1080) – IPS 270 nits – Xoay 360 độ Kèm bút cảm ứng – Camera hổ trợ nhận diện khuôn mặt\r\nOption Backlit Keyboard , Finger Print\r\nPin : 4 Cell Lithium-Polymer (52 Wh)\r\nKhổi Lượng : 1.2Kg\r\nHệ điều hành Windows 10 Profession (64-bit)\r\nPort 2 x USB 3.1, 2 x USB 3.1 Gen 2 Type-C / Intel Thunderbolt 3 HDMI, Headphone / microphone combo jack', 2),
(5, 'Laptop Asus ProArt StudioBook Pro W700G3T Xeon E-2276M, Ram 32GB, 1TB SSD, Nvidia Quadro RTX 3000, 17.3 Inch Full HD', 55000000, 'https://hungthinhhitech.vn/uploads/product/LAPTOP/ASUS/Laptop_Asus_ProArt_StudioBook_Pro_W700G3T_1.jpg', 'TÌNH TRẠNG : ĐÃ QUA SỬ DỤNG\r\nBẢO HÀNH : 06 THÁNG (LIKE NEW 99%)\r\nThương Hiệu: ASUS\r\nModel: Pro Art\r\nCPU: Intel® Xeon E-2276M (6-Core 12 Threads 12MB Cache up to 4.7GHz)\r\nRAM: 32GB DDR4-2666MHz ECC Memory\r\nỔ cứng: 1TB PCIe NVMe SSD\r\nCD/DVD: None\r\nCard: VGA NVIDIA Quadro RTX 3000 with 6GB GDDR6\r\nMàn hình: 17\'\' WUXGA 16:10 ratio panel (1920*1200) NanoEdge matte display, 97% DCI-P3 wide color gamut\r\nKết nối: Wifi 802.11 AC + Bluetooth® 5\r\nTích hợp\r\n1 x Thunderbolt 3 USB-C with Display Port 1.4 (40Gbps), 3 x USB 3.1 Gen 2 Type-A (10Gbps), 1 x HDMI 2.0, 1 x SD 4.0 / UHS-II Card reader (312MB/s), 1 x Audio combo jack\r\nBàn phím Full-size backlit keyboard with 1.4mm key travel and privacy hotkeys\r\nTrọng lượng: 1.9 Kg\r\nPin: 76 Whr, 4-cell Battery (Integrated)\r\nHệ điều hành: WINDOWS 10 Pro', 2),
(6, 'Điện Thoại Nokia 3.2 (2GB/16GB) - Đã Qua Sử Dụng', 1850000, 'https://hungthinhhitech.vn/uploads/product/DIEN_THOAI/NOKIA/ien_Thoai_Nokia_3.2_1.jpg', 'GIÁ THỊ TRƯỜNG : 2.490.000 VND\r\nTÌNH TRẠNG : ĐÃ QUA SỬ DỤNG\r\nBẢO HÀNH : 06 THÁNG (HÀNG TỒN KHO )\r\nThiết kế: Màn hình giọt nước\r\nMàn hình: IPS LCD, 6.2\", HD+\r\nCamera Trước/Sau: 5MP/13MP\r\nCPU: Snapdragon 429 4 nhân 64-bit\r\nBộ Nhớ: 16GB\r\nRAM: 2GB\r\nTính năng: Mở khóa bằng khuôn mặt\r\nHiển thị màu sắc : 16.7 triệu màu\r\nTính năng camera : Tự động lấy nét, Chạm lấy nét, Nhận diện khuôn mặt, HDR, Panorama\r\nĐèn Flash : Có\r\nVideo call : Hỗ trợ VideoCall thông qua ứng dụng\r\nQuay phim : Quay video HD, Tự động lấy nét\r\nChip đồ họa (GPU) : Adreno 504\r\nDung lượng pin : 4000 mAh\r\nCổng sạc : Micro USB\r\nJack tai nghe : 3.5mm', 1),
(7, 'Samsung Galaxy A03s', 3490000, 'https://images.fpt.shop/unsafe/fit-in/800x800/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2021/8/22/637652436818507220_samsung-a03s-den-1.jpg', 'Thương hiệu:  \r\nSamsung\r\nThời gian ra mắt:  \r\n08/2021\r\nSeries:  \r\nGalaxy A03s\r\nThời gian bảo hành:  \r\n12 Tháng\r\nXuất xứ:  \r\nViệt Nam/Trung Quốc\r\nBộ nhớ trong	64 GB\r\nDanh bạ lưu trữ	Không giới hạn\r\nThẻ nhớ ngoài	MicroSD\r\nHổ trợ thẻ nhớ tối đa	1 TB\r\nBộ nhớ còn lại	Khoảng 54 GB', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
