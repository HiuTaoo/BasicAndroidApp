use QLSV


select HoTen, SinhVien.Email
from [Admin] inner join SinhVien on SinhVien.ID = [Admin].ID
where [Admin].UserName = 'Hiutao' and [Admin].Password = '123'

create proc getInfo @username nvarchar(50), @password nvarchar(50) as
begin
	select HoTen, SinhVien.Email
	from [Admin] inner join SinhVien on SinhVien.ID = [Admin].ID
	where [Admin].UserName = @username and [Admin].Password = @password
end

exec getInfo @username='Hiutao', @password ='123'

alter proc changePassword @newpass nvarchar(50),@username nvarchar(50), @password nvarchar(50) as 
begin
	declare @id nvarchar(100)
	set @id = (select [TKSinhVien].ID
				from [TKSinhVien] inner join SinhVien on SinhVien.ID = [TKSinhVien].ID
				where [TKSinhVien].ID = @username and [TKSinhVien].PassWordSV = @password)
	update [TKSinhVien]
	set PassWordSV = @newpass
	where ID = @id
end

exec changePassword @newpass='12345', @username = '211240892', @password = '123456'

select distinct HocPhan.MaHP, HocPhan.TenHP, ChiTietTC.MaCTHP
from HocPhan inner join ChiTietTC on HocPhan.MaHP = ChiTietTC.MaHP

create proc getListCourse as
begin
	select distinct HocPhan.MaHP, HocPhan.TenHP, HocPhan.TenHP, HocPhan.SL, HocPhan.SLDK, HocPhan.SoTC
	from HocPhan inner join ChiTietTC on HocPhan.MaHP = ChiTietTC.MaHP
end

exec getListCourse

select distinct HocPhan.MaHP, HocPhan.TenHP, ChiTietTC.MaCTHP, ChiTietTC.[Start], ChiTietTC.[End], ChiTietTC.Ca, ChiTietTC.Thu
from HocPhan inner join ChiTietTC on HocPhan.MaHP = ChiTietTC.MaHP
where HocPhan.MaHP = 'IT1.221.3'

create proc getDetailCourse @mahp nvarchar(100) as
begin
	select distinct HocPhan.MaHP, HocPhan.TenHP, ChiTietTC.MaCTHP, ChiTietTC.[Start], ChiTietTC.[End],ChiTietTC.Phong, ChiTietTC.Ca, ChiTietTC.Thu
	from HocPhan inner join ChiTietTC on HocPhan.MaHP = ChiTietTC.MaHP
	where HocPhan.MaHP = @mahp
end

exec getDetailCourse @mahp = 'IT1.220.3'

create type KQDK_Type as table (
	[ID] [nvarchar](100)  NULL,
	[MaHP] [nvarchar](100) NULL, 
	[isDeleted] bit
)


create PROCEDURE insertKQDK 
    @kqdk KQDK_Type READONLY 
AS
BEGIN
    -- Kiểm tra xem các bản ghi đã tồn tại trong bảng KQDK hay chưa
    MERGE INTO KQDK AS Target
    USING @kqdk AS Source
    ON (Target.ID = Source.ID AND Target.MaHP = Source.MaHP)
    WHEN NOT MATCHED THEN	
        -- Chèn các bản ghi mới
        INSERT (ID, MaHP, IsDeleted) VALUES (Source.ID, Source.MaHP, Source.IsDeleted);
    -- Cập nhật số lượng đăng ký trong bảng HocPhan
		
	
END;


declare @kqdk_type KQDK_Type
insert into @kqdk_type(ID, MaHP, [isDeleted]) values ('001', 'IT1.222.3',0)
exec insertKQDK @kqdk = @kqdk_type

create proc updateKQDK @mahp nvarchar(100) as begin
	UPDATE HocPhan
		SET SLDK = SLDK + 1
		WHERE MaHP = @mahp
end

exec updateKQDK @mahp = 'IT1.220.3'

select distinct HocPhan.MaHP, HocPhan.TenHP, ChiTietTC.MaCTHP, 
ChiTietTC.[Start], ChiTietTC.[End], ChiTietTC.Ca, ChiTietTC.Thu
from HocPhan inner join ChiTietTC on HocPhan.MaHP = ChiTietTC.MaHP 
inner join KQDK on KQDK.MaHP = HocPhan.MaHP
where KQDK.ID = '001'

create proc get_KQDK_by_ID @id nvarchar(100) as begin
	select distinct HocPhan.MaHP, HocPhan.TenHP, ChiTietTC.MaCTHP, 
	ChiTietTC.[Start], ChiTietTC.[End], ChiTietTC.Ca, ChiTietTC.Thu
	from HocPhan inner join ChiTietTC on HocPhan.MaHP = ChiTietTC.MaHP 
	inner join KQDK on KQDK.MaHP = HocPhan.MaHP
	where KQDK.ID = @id
end

exec get_KQDK_by_ID @id = '002'

create proc get_LichHoc @id nvarchar(100) as begin
	select distinct HocPhan.MaHP, HocPhan.TenHP, ChiTietTC.MaCTHP, 
	ChiTietTC.[Start], ChiTietTC.[End], ChiTietTC.Ca, ChiTietTC.Thu
	from HocPhan inner join ChiTietTC on HocPhan.MaHP = ChiTietTC.MaHP 
	inner join KQDK on KQDK.MaHP = HocPhan.MaHP
	where KQDK.ID = @id and '2024-2-8' between ChiTietTC.Start and ChiTietTC.[End]
end

exec get_LichHoc @id = '211240892'

select LichThi.ID, HocPhan.MaHp,HocPhan.TenHp, LichThi.NgayThi, LichThi.ThoiGian, LichThi.HinhThuc, LichThi.PhongThi, LichThi.SBD
from LichThi inner join HocPhan on HocPhan.MaHP = LichThi.MaHP

create proc getLichThi @id nvarchar(100) as begin
	select LichThi.ID, HocPhan.MaHP,HocPhan.TenHP, LichThi.NgayThi, LichThi.ThoiGian, LichThi.HinhThuc, LichThi.PhongThi, LichThi.SBD
	from LichThi inner join HocPhan on HocPhan.MaHP = LichThi.MaHP
	where LichThi.ID = @id
end

exec getLichThi @id = '001'


create type ChangeProfile as table (
	[ID] [nchar](100),
	[HoTen] [nchar](100) NULL,
	[NgaySinh] [datetime] NULL,
	[SDT] [nchar](100) NULL,
	[DiaChi] [nchar](100) NULL,
	[Email] [nchar](100) NULL
)

drop type ChangeProfile
drop procedure changeProfile

create PROCEDURE changeProfile
    @input ChangeProfile READONLY
AS
BEGIN
    UPDATE SinhVien
    SET HoTen = inp.HoTen,
        NgaySinh = inp.NgaySinh,
		SDT = inp.SDT,
		Email = inp.Email,
		DiaChi = inp.DiaChi
    FROM SinhVien 
	INNER JOIN @input AS inp ON SinhVien.ID = inp.ID
    WHERE SinhVien.ID = inp.ID;
END;

DECLARE @inp ChangeProfile;
INSERT INTO @inp (ID, HoTen, NgaySinh, SDT, DiaChi, Email) VALUES ('211240892', 'HiuTao', '1990-01-01', '123456789', '123 Main St', 'john.doe@example.com');
EXEC changeProfile @input = @inp

create proc getInfoByID @id nchar(100) as begin
	select HoTen, NgaySinh, SDT, DiaChi, Email
	from SinhVien
	where ID = @id
end

exec getInfoByID '001'


