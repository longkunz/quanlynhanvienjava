--TẠO DATABASE
CREATE DATABASE Project_Java_Nhom_HoSiHung;
GO
USE Project_Java_Nhom_HoSiHung;
GO
--TẠO BẢNG NHÂN VIÊN
CREATE TABLE NhanVien
(
	 MaNV nvarchar(5) not null
	,HoTen nvarchar(100)
	,NgSinh date
	,CMND nvarchar(9)
	,DiaChi nvarchar(200)
	,CONSTRAINT PK_NhanVien PRIMARY KEY (MaNV)
)

GO
--TẠO BẢNG NHÂN VIÊN chính thức
CREATE TABLE NVChinhThuc
(
	 MaNV nvarchar(5) not null
	,HeSoLuong float
	,CONSTRAINT PK_NVCT PRIMARY KEY (MaNV)
	,CONSTRAINT PK_NVCT_NhanVien FOREIGN KEY (MaNV) REFERENCES NhanVien (MaNV)
)
GO	
--TẠO BẢNG NHÂN VIÊN Hợp đồng
CREATE TABLE NVHopDong
(
	 MaNV nvarchar(5) not null
	,SoNgayCong int
	,CONSTRAINT PK_NVHD PRIMARY KEY (MaNV)
	,CONSTRAINT PK_NVHD_NhanVien FOREIGN KEY (MaNV) REFERENCES NhanVien (MaNV)
)
GO
--TẠO BẢNG NHÂN VIÊN Part time
CREATE TABLE NVPartTime
(
	 MaNV nvarchar(5) not null
	,SoGioLam int
	,CONSTRAINT PK_NVPartTime PRIMARY KEY (MaNV)
	,CONSTRAINT PK_NVPartTime_NhanVien FOREIGN KEY (MaNV) REFERENCES NhanVien (MaNV)
)
GO	
--SP ĐỌC DỮ LIỆU
CREATE proc getData @tableName nvarchar(50)
AS BEGIN
	EXEC ('SELECT * FROM ' + @tableName );
END;
GO
--insert data into NhanVien Table
GO
CREATE proc insertDataNhanVien @MaNV nvarchar(6), @HoTen nvarchar(100),
	@NgSinh date, @CMND nvarchar(9), @DiaChi nvarchar(200)
AS BEGIN
	INSERT INTO NhanVien VALUES (@MaNV,@HoTen,@NgSinh,@CMND,@DiaChi);
END;
GO
exec insertDataNhanVien 'NV000',N'Nguyễn Thành Anh','2000-08-15', '987654321',N'Huế';
GO
exec insertDataNhanVien 'NV001',N'Quách Thanh Bình','2000-01-28', '987458321',N'Hà Nội';
GO
exec insertDataNhanVien 'NV002',N'Trương Tuấn Kiệt','2000-04-28', '987642321',N'Nha Trang';
GO
exec insertDataNhanVien 'NV003',N'Vương Doãn','2002-06-08', '987578431',N'Gia Định';
GO
exec insertDataNhanVien 'NV004',N'Trương Ngô Bảo','1998-04-02', '984529321',N'Nha Trang';
GO
exec insertDataNhanVien 'NV005',N'Dương Tuấn Hào','2002-08-19', '987458321',N'Vinh';
GO
exec insertDataNhanVien 'NV006',N'Hồ Viết Long','2000-08-19', '987458321',N'Huế';
GO
exec insertDataNhanVien 'NV007',N'Phạm Quốc Huy','2000-04-02', '985658321',N'Huế';
GO
exec insertDataNhanVien 'NV008',N'Trần Đăng Dưỡng','2000-12-13', '987328321',N'Huế';
GO
exec insertDataNhanVien 'NV009',N'Phạm Bá Huy','2000-09-19', '987458321',N'Huế';
GO
exec insertDataNhanVien 'NV010',N'Lê Hữu Hào','2000-06-28', '987473321',N'Đà Nẵng';
GO
exec insertDataNhanVien 'NV011',N'Tồ Lế Rô','2000-04-16', '987458321',N'Hà Nội';
GO
exec insertDataNhanVien 'NV012',N'Lê Văn Việt','2001-07-20', '987458321',N'Phú Quốc';
GO
exec insertDataNhanVien 'NV013',N'Nguyễn Hữu Xoài','2001-08-08', '987458321',N'Vũng Tàu';
GO
exec insertDataNhanVien 'NV014',N'Từ Biệt','2001-02-19', '987458321',N'Long An';
GO
--THÊM DỮ LIỆU BẢNG NV CHÍNH THỨC
INSERT INTO NVChinhThuc VALUES ('NV000', 2.5);
GO
INSERT INTO NVChinhThuc VALUES ('NV001', 1.8);
GO
INSERT INTO NVChinhThuc VALUES ('NV002', 2.8);
GO
INSERT INTO NVChinhThuc VALUES ('NV003', 3.8);
GO
INSERT INTO NVChinhThuc VALUES ('NV004', 4.8);
GO
--THÊM DỮ LIỆU BẢNG NV PART TIME
INSERT INTO NVPartTime VALUES ('NV005', 75);
GO
INSERT INTO NVPartTime VALUES ('NV006', 30);
GO
INSERT INTO NVPartTime VALUES ('NV007', 40);
GO
INSERT INTO NVPartTime VALUES ('NV008', 35);
GO
INSERT INTO NVPartTime VALUES ('NV009', 32);
GO

--THÊM DỮ LIỆU BẢNG NV HỢP ĐỒNG
INSERT INTO NVHopDong VALUES ('NV010', 28);
GO
INSERT INTO NVHopDong VALUES ('NV011', 15);
GO
INSERT INTO NVHopDong VALUES ('NV012', 26);
GO
INSERT INTO NVHopDong VALUES ('NV013', 25);
GO
INSERT INTO NVHopDong VALUES ('NV014', 15);
GO
--THÊM BẢNG TAIKHOAN
CREATE TABLE TAIKHOAN
(
USERNAME VARCHAR(10) NOT NULL PRIMARY KEY,
PASS VARCHAR(10)
)
GO
--THÊM DỮ LIỆU VÀO BẢNG TAIKHOAN
INSERT INTO TAIKHOAN
VALUES('admin','123')

