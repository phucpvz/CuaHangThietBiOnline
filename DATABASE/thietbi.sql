-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 31, 2021 lúc 09:15 PM
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
-- Cấu trúc bảng cho bảng `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `id` int(11) NOT NULL,
  `madonhang` int(11) NOT NULL,
  `masanpham` int(11) NOT NULL,
  `soluongsanpham` int(11) NOT NULL,
  `tongtiensanpham` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`id`, `madonhang`, `masanpham`, `soluongsanpham`, `tongtiensanpham`) VALUES
(1, 2, 2, 2, 6400000),
(2, 2, 3, 4, 50000000),
(3, 3, 19, 2, 17180000),
(4, 3, 15, 1, 14990000),
(5, 3, 12, 3, 56997000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donhang`
--

CREATE TABLE `donhang` (
  `id` int(11) NOT NULL,
  `tenkhachhang` varchar(200) NOT NULL,
  `sodienthoai` varchar(10) NOT NULL,
  `email` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `donhang`
--

INSERT INTO `donhang` (`id`, `tenkhachhang`, `sodienthoai`, `email`) VALUES
(1, 'phuc', '0962792172', 'phuc@gmail.com'),
(2, 'Phát', '0938389999', 'phatandroid@yahoo.com'),
(3, 'Phúc', '0927334923', 'phucandroid@gmail.com');

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
(7, 'Samsung Galaxy A03s', 3490000, 'https://images.fpt.shop/unsafe/fit-in/800x800/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2021/8/22/637652436818507220_samsung-a03s-den-1.jpg', 'Thương hiệu:  \r\nSamsung\r\nThời gian ra mắt:  \r\n08/2021\r\nSeries:  \r\nGalaxy A03s\r\nThời gian bảo hành:  \r\n12 Tháng\r\nXuất xứ:  \r\nViệt Nam/Trung Quốc\r\nBộ nhớ trong	64 GB\r\nDanh bạ lưu trữ	Không giới hạn\r\nThẻ nhớ ngoài	MicroSD\r\nHổ trợ thẻ nhớ tối đa	1 TB\r\nBộ nhớ còn lại	Khoảng 54 GB', 1),
(9, 'Samsung Galaxy Note 20 Ultra', 19990000, 'https://images.fpt.shop/unsafe/fit-in/800x800/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/8/5/637322682441632129_ss-note-20-ultra-gold-1.png', 'Samsung Galaxy Note 20 Ultra được chế tác từ những vật liệu cao cấp hàng đầu hiện nay, với sự tỉ mỉ và chất lượng gia công thượng thừa, tạo nên chiếc điện thoại đẹp hơn những gì bạn có thể tưởng tượng. Không chỉ có kiểu dáng thanh lịch, màn hình không viền Infinity-O quyến rũ, Galaxy Note20 Ultra còn thể hiện sự cao cấp ở từng chi tiết nhỏ như các phần viền cạnh sáng bóng, họa tiết phay xước độc đáo trên khung máy, mang đến niềm cảm hứng cho người dùng ở mọi góc cạnh.', 1),
(10, 'Laptop MSI Gaming GF63 Thin 10SC-481VN i7 10750H/8GB/512GB/15.6\"FHD/GTX 1650 Max-Q 4GB/Win 10', 22999000, 'https://images.fpt.shop/unsafe/fit-in/800x800/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2021/8/7/637639340541330187_msi-gaming-gf63-den-1.jpg', 'MSI Gaming GF63 Thin 10SC 481VN là chiếc laptop gaming rất đáng mua ở phân khúc 20 triệu đồng khi vừa nhỏ gọn di động, lại vừa trang bị bộ vi xử lý Intel Core i7 10750H siêu mạnh, đi cùng card đồ họa rời GTX 1650 chuyên game.', 2),
(11, 'Laptop Asus VivoBook X515EA-BR1409T i5 1135G7/8GB/512GB SSD/Win10', 17599000, 'https://images.fpt.shop/unsafe/fit-in/800x800/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2021/10/29/637711442236948468_asus-vivobook-x515-xam-1.jpg', 'ASUS VivoBook X515EA sở hữu kiểu dáng thanh lịch với các đường nét vuông vắn khỏe khắn, viền màn hình siêu mỏng cho vẻ đẹp hiện đại, tối giản. Hơn nữa, phiên bản VivoBook X515EA BR1409T được sơn màu xám bạc năng động, mạnh mẽ kết hợp cùng khu vực bàn phím màu đen mang đến một thiết kế không bị lỗi thời. VivoBook 15 X515 cũng là một chiếc laptop tương đối nhỏ gọn với trọng lượng chỉ 1,8kg cùng độ mỏng 19,9mm, dễ dàng đồng hành cùng bạn đi bất cứ đâu.', 2),
(12, 'Laptop Asus Vivobook M513UA-L1230T R5 5500U/8GB/512GB SSD/15.6\" OLED FHD/Win 10 ', 18999000, 'https://images.fpt.shop/unsafe/fit-in/800x800/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2021/8/17/637647975201013013_asus-vivobook-m513-bac-oled-1.jpg', 'ASUS VivoBook M513 là dòng laptop phổ thông đầu tiên trên thị trường trang bị màn hình OLED cao cấp, cho bạn trải nghiệm hình ảnh sống động hơn bao giờ hết. Bên cạnh đó, sức mạnh của bộ vi xử lý Ryzen 5000 series cũng sẽ giúp bạn làm việc hiệu quả với năng suất cao nhất.', 2),
(13, 'Laptop Lenovo IdeaPad Slim 3 15ADA05 R5 3500U/8GB/512GB SSD/15.6HD Touch/Win 10', 14499000, 'https://images.fpt.shop/unsafe/fit-in/800x800/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/9/10/637353563373685359_lenovo-ideapad-5-xamnhat-1.png', 'Màn hình: 15.6\", 1366 x 768 Pixel, TN, 220 nits, LED Backlit\r\nCPU: AMD Ryzen 5-3500U\r\nRAM: 8 GB, DDR4, 2400 MHz\r\nSSD: 512 GB\r\nCard đồ họa: AMD Radeon Graphics Vega 8', 2),
(14, 'Samsung Galaxy Z Fold3 5G 256GB', 40990000, 'https://images.fpt.shop/unsafe/fit-in/800x800/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2021/8/11/637643195814330368_samsung-galaxy-z-fold3-xanh-1.jpg', 'Khi bạn mở ra màn hình gập lớn tới 7,6 inch trên Samsung Galaxy Z Fold3 5G là lúc bạn đã mở ra một tương lai hoàn toàn mới cho thế giới smartphone, nơi công nghệ vượt qua mọi giới hạn, cho trải nghiệm hoàn hảo nhất ở một thiết bị di động nhỏ gọn.', 1),
(15, 'Điện thoại iPhone 11 64GB ', 14990000, 'https://cdn.tgdd.vn/Products/Images/42/153856/iphone-11-do-1-1-1-org.jpg', 'Apple đã chính thức trình làng bộ 3 siêu phẩm iPhone 11, trong đó phiên bản iPhone 11 64GB có mức giá rẻ nhất nhưng vẫn được nâng cấp mạnh mẽ như iPhone Xr ra mắt trước đó.\r\nNâng cấp mạnh mẽ về camera\r\nNói về nâng cấp thì camera chính là điểm có nhiều cải tiến nhất trên thế hệ iPhone mới.', 1),
(16, 'Điện thoại OPPO Reno6 Z 5G ', 9490000, 'https://cdn.tgdd.vn/Products/Images/42/239747/oppo-reno6-z-5g-bac-1-org.jpg', 'Reno6 Z 5G đến từ nhà OPPO với hàng loạt sự nâng cấp và cải tiến không chỉ ngoại hình bên ngoài mà còn sức mạnh bên trong. Đặc biệt, chiếc điện thoại được hãng đánh giá “chuyên gia chân dung bắt trọn mọi cảm xúc chân thật nhất”, đây chắc chắn sẽ là một “siêu phẩm\" mà bạn không thể bỏ qua.\r\nBộ 3 camera chuyên nghiệp - Mỗi cảm xúc, một chân dung\r\nHệ thống camera sau được trang bị tối tân, trong đó có camera chính 64 MP, camera góc siêu rộng 8 MP và camera macro 2 MP cùng camera trước 32 MP luôn sẵn sàng bắt trọn mọi cảm xúc trong khung hình, giúp người dùng thoải mái ghi lại những khoảnh khắc trong cuộc sống một cách ấn tượng nhất.', 1),
(17, 'Điện thoại iPhone 13 Pro Max 128GB ', 32990000, 'https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-xanh-1.jpg', 'iPhone 13 Pro Max 128GB - siêu phẩm được mong chờ nhất ở nửa cuối năm 2021 đến từ Apple. Máy có thiết kế không mấy đột phá khi so với người tiền nhiệm, bên trong đây vẫn là một sản phẩm có màn hình siêu đẹp, tần số quét được nâng cấp lên 120 Hz mượt mà, cảm biến camera có kích thước lớn hơn, cùng hiệu năng mạnh mẽ với sức mạnh đến từ Apple A15 Bionic, sẵn sàng cùng bạn chinh phục mọi thử thách.\r\nThiết kế đẳng cấp hàng đầu\r\niPhone mới kế thừa thiết kế đặc trưng từ iPhone 12 Pro Max khi sở hữu khung viền vuông vức, mặt lưng kính cùng màn hình tai thỏ tràn viền nằm ở phía trước.', 1),
(18, 'Điện thoại OPPO A95', 6990000, 'https://cdn.tgdd.vn/Products/Images/42/251703/oppo-a95-4g-bac-1-1.jpg', 'Bên cạnh phiên bản 5G, OPPO còn bổ sung phiên bản OPPO A95 4G với giá thành phải chăng tập trung vào thiết kế năng động, sạc nhanh và hiệu năng đa nhiệm ấn tượng sẽ giúp cho cuộc sống của bạn thêm phần hấp dẫn, ngập tràn niềm vui.\r\nThiết kế hiện đại, mỏng nhẹ thời trang\r\nOPPO A95 có thiết kế trẻ trung hiện đại với công nghệ phủ màu độc quyền OPPO. Nó mềm mại mượt mà, chống mài mòn và chống bám vân tay một cách hiệu quả.', 1),
(19, 'Điện thoại Samsung Galaxy A52 128GB ', 8590000, 'https://cdn.tgdd.vn/Products/Images/42/228967/samsung-galaxy-a52-8gb-256gb-thumb-violet-1020x680-org.jpg', 'Galaxy A52 (8GB/128GB) mẫu smartphone thuộc dòng Galaxy A của Samsung, với nhiều sự thay đổi lớn về thiết kế lẫn cấu hình, cung cấp những công nghệ đột phá, thiết lập tiêu chuẩn trải nghiệm mới cho người dùng ở phân khúc tầm trung.\r\nThiết kế tươi mới thời trang\r\nSamsung Galaxy A52 được khoác lên một diện mạo mới, không còn vẻ bóng bẩy như thế hệ trước, mẫu điện thoại quay về với mặt lưng phẳng được phủ nhám hạn chế dấu vân tay, kèm theo nhiều màu sắc trẻ trung, phù hợp cho giới trẻ hiện nay.', 1),
(20, 'Điện thoại Samsung Galaxy Z Flip3 5G 256GB ', 26990000, 'https://cdn.tgdd.vn/Products/Images/42/248283/samsung-galaxy-z-flip-3-black-gc-org.jpg', 'Nối tiếp thành công của Galaxy Z Flip 5G, trong sự kiện Galaxy Unpacked vừa qua Samsung tiếp tục giới thiệu đến thế giới về Galaxy Z Flip3 5G 256GB. Sản phẩm có nhiều cải tiến từ độ bền cho đến hiệu năng và thậm chí nó còn vượt xa hơn mong đợi của mọi người.\r\nThiết kế nhỏ gọn đầy lôi cuốn\r\nSamsung Galaxy Z Flip3 5G dễ dàng lấy lòng phái nữ khi thiết kế của nó được lấy cảm hứng từ hộp đựng phấn trang điểm. Kết hợp với 7 màu sắc khác nhau, giúp bạn thoải mái thể hiện cá tính, từ mạnh mẽ sang trọng đến hiện đại trẻ trung.', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`);

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
-- AUTO_INCREMENT cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
