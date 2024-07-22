USE [master]
GO
/****** Object:  Database [QLSV]    Script Date: 5/8/2024 5:36:53 PM ******/
CREATE DATABASE [QLSV]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLSV', FILENAME = N'D:\SQL\MSSQL16.HIUTAO\MSSQL\DATA\QLSV.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QLSV_log', FILENAME = N'D:\SQL\MSSQL16.HIUTAO\MSSQL\DATA\QLSV_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [QLSV] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLSV].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLSV] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLSV] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLSV] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLSV] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLSV] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLSV] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QLSV] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLSV] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLSV] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLSV] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLSV] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLSV] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLSV] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLSV] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLSV] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QLSV] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLSV] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLSV] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLSV] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLSV] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLSV] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLSV] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLSV] SET RECOVERY FULL 
GO
ALTER DATABASE [QLSV] SET  MULTI_USER 
GO
ALTER DATABASE [QLSV] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLSV] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLSV] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLSV] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QLSV] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QLSV] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'QLSV', N'ON'
GO
ALTER DATABASE [QLSV] SET QUERY_STORE = ON
GO
ALTER DATABASE [QLSV] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QLSV]
GO
/****** Object:  UserDefinedTableType [dbo].[ChangeProfile]    Script Date: 5/8/2024 5:36:53 PM ******/
CREATE TYPE [dbo].[ChangeProfile] AS TABLE(
	[ID] [nchar](100) NULL,
	[HoTen] [nchar](100) NULL,
	[NgaySinh] [datetime] NULL,
	[SDT] [nchar](100) NULL,
	[DiaChi] [nchar](100) NULL,
	[Email] [nchar](100) NULL
)
GO
/****** Object:  UserDefinedTableType [dbo].[KQDK_Type]    Script Date: 5/8/2024 5:36:53 PM ******/
CREATE TYPE [dbo].[KQDK_Type] AS TABLE(
	[ID] [nvarchar](100) NULL,
	[MaHP] [nvarchar](100) NULL,
	[isDeleted] [bit] NULL
)
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 5/8/2024 5:36:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admin](
	[ID] [nchar](100) NOT NULL,
	[UserName] [nchar](100) NULL,
	[Password] [nchar](100) NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietTC]    Script Date: 5/8/2024 5:36:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietTC](
	[MaHP] [nchar](100) NOT NULL,
	[MaCTHP] [nchar](100) NOT NULL,
	[Start] [datetime] NULL,
	[End] [datetime] NULL,
	[Phong] [nchar](100) NULL,
	[Ca] [nchar](10) NULL,
	[Thu] [nchar](10) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HocPhan]    Script Date: 5/8/2024 5:36:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HocPhan](
	[MaHP] [nchar](100) NOT NULL,
	[TenHP] [nchar](100) NULL,
	[SoTC] [nchar](10) NULL,
	[SL] [int] NULL,
	[SLDK] [int] NULL,
 CONSTRAINT [PK_HocPhan] PRIMARY KEY CLUSTERED 
(
	[MaHP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KetQua]    Script Date: 5/8/2024 5:36:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KetQua](
	[MaHP] [nchar](100) NOT NULL,
	[ID] [nchar](100) NULL,
	[DiemQT] [float] NULL,
	[DiemThi] [float] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Khoa]    Script Date: 5/8/2024 5:36:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Khoa](
	[MaKhoa] [nchar](10) NOT NULL,
	[TenKhoa] [nchar](10) NULL,
 CONSTRAINT [PK_Khoa] PRIMARY KEY CLUSTERED 
(
	[MaKhoa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KQDK]    Script Date: 5/8/2024 5:36:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KQDK](
	[ID] [nchar](100) NULL,
	[MaHP] [nchar](100) NULL,
	[IsDeleted] [bit] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LichThi]    Script Date: 5/8/2024 5:36:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LichThi](
	[ID] [nchar](100) NULL,
	[MaHP] [nchar](100) NULL,
	[NgayThi] [date] NULL,
	[ThoiGian] [nchar](100) NULL,
	[HinhThuc] [nchar](100) NULL,
	[PhongThi] [nchar](10) NULL,
	[SBD] [nchar](10) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NienKhoa]    Script Date: 5/8/2024 5:36:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NienKhoa](
	[Khoa] [nchar](100) NOT NULL,
	[Start] [nchar](100) NULL,
 CONSTRAINT [PK_NienKhoa] PRIMARY KEY CLUSTERED 
(
	[Khoa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SinhVien]    Script Date: 5/8/2024 5:36:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SinhVien](
	[ID] [nchar](100) NOT NULL,
	[HoTen] [nchar](100) NULL,
	[GioiTinh] [bit] NULL,
	[NgaySinh] [nchar](100) NULL,
	[SDT] [nchar](100) NULL,
	[DiaChi] [nchar](100) NULL,
	[Email] [nchar](100) NULL,
	[MaKhoa] [nchar](100) NULL,
	[Khoa] [nchar](10) NULL,
 CONSTRAINT [PK_SinhVien] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TKSinhVien]    Script Date: 5/8/2024 5:36:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TKSinhVien](
	[ID] [nchar](100) NOT NULL,
	[PassWordSV] [nchar](100) NOT NULL
) ON [PRIMARY]
GO
INSERT [dbo].[Admin] ([ID], [UserName], [Password]) VALUES (N'001                                                                                                 ', N'Hiutao                                                                                              ', N'123                                                                                                 ')
INSERT [dbo].[Admin] ([ID], [UserName], [Password]) VALUES (N'002                                                                                                 ', N'Dctien                                                                                              ', N'admin                                                                                               ')
INSERT [dbo].[Admin] ([ID], [UserName], [Password]) VALUES (N'003                                                                                                 ', N'Anhb                                                                                                ', N'123                                                                                                 ')
GO
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.219.3                                                                              IT1.222.3    ', N'N07                                                                                                 ', CAST(N'2024-01-01T00:00:00.000' AS DateTime), CAST(N'2024-01-28T00:00:00.000' AS DateTime), N'202-A5                                                                                              ', N'4         ', N'6         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.219.3                                                                              IT1.222.3    ', N'N07                                                                                                 ', CAST(N'2024-02-19T00:00:00.000' AS DateTime), CAST(N'2024-03-03T00:00:00.000' AS DateTime), N'202-A5                                                                                              ', N'4         ', N'6         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.219.3                                                                              IT1.222.3    ', N'N07.BT                                                                                              ', CAST(N'2024-03-04T00:00:00.000' AS DateTime), CAST(N'2024-04-14T00:00:00.000' AS DateTime), N'202-A5                                                                                              ', N'4         ', N'6         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.219.3                                                                              IT1.222.3    ', N'N07.TH                                                                                              ', CAST(N'2024-01-01T00:00:00.000' AS DateTime), CAST(N'2024-05-05T00:00:00.000' AS DateTime), NULL, NULL, NULL)
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.228.2                                                                                           ', N'N07                                                                                                 ', CAST(N'2021-01-01T00:00:00.000' AS DateTime), CAST(N'2024-01-28T00:00:00.000' AS DateTime), N'302-A5                                                                                              ', N'3         ', N'5         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.228.2                                                                                           ', N'N07                                                                                                 ', CAST(N'2024-02-19T00:00:00.000' AS DateTime), CAST(N'2024-03-03T00:00:00.000' AS DateTime), N'302-A5                                                                                              ', N'3         ', N'5         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.228.2                                                                                           ', N'N07.TH                                                                                              ', CAST(N'2024-01-01T00:00:00.000' AS DateTime), CAST(N'2024-05-05T00:00:00.000' AS DateTime), NULL, NULL, NULL)
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.226.3                                                                                           ', N'N07                                                                                                 ', CAST(N'2024-01-01T00:00:00.000' AS DateTime), CAST(N'2024-01-28T00:00:00.000' AS DateTime), N'302-A5                                                                                              ', N'4         ', N'7         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.226.3                                                                                           ', N'N07                                                                                                 ', CAST(N'2024-02-19T00:00:00.000' AS DateTime), CAST(N'2024-04-07T00:00:00.000' AS DateTime), N'302-A5                                                                                              ', N'4         ', N'7         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.226.3                                                                                           ', N'N07.BT                                                                                              ', CAST(N'2024-08-04T00:00:00.000' AS DateTime), CAST(N'2024-04-14T00:00:00.000' AS DateTime), N'302-A5                                                                                              ', N'4         ', N'5         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.226.3                                                                                           ', N'N07.BT                                                                                              ', CAST(N'2024-08-04T00:00:00.000' AS DateTime), CAST(N'2024-04-14T00:00:00.000' AS DateTime), N'302-A5                                                                                              ', N'4         ', N'7         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.226.3                                                                                           ', N'N07.BT                                                                                              ', CAST(N'2024-04-15T00:00:00.000' AS DateTime), CAST(N'2024-04-21T00:00:00.000' AS DateTime), N'302-A5                                                                                              ', N'4         ', N'7         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.226.3                                                                                           ', N'N07.BT                                                                                              ', CAST(N'2024-04-29T00:00:00.000' AS DateTime), CAST(N'2024-05-05T00:00:00.000' AS DateTime), N'302-A5                                                                                              ', N'4         ', N'5         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.226.3                                                                                           ', N'N07.TH                                                                                              ', CAST(N'2024-01-01T00:00:00.000' AS DateTime), CAST(N'2024-05-05T00:00:00.000' AS DateTime), NULL, NULL, NULL)
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.219.3                                                                                           ', N'N07                                                                                                 ', CAST(N'2024-01-01T00:00:00.000' AS DateTime), CAST(N'2024-01-28T00:00:00.000' AS DateTime), N'201-A5                                                                                              ', N'1         ', N'3         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.219.3                                                                                           ', N'N07                                                                                                 ', CAST(N'2024-02-19T00:00:00.000' AS DateTime), CAST(N'2024-02-25T00:00:00.000' AS DateTime), N'201-A5                                                                                              ', N'1         ', N'3         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.219.3                                                                                           ', N'N07                                                                                                 ', CAST(N'2024-02-29T00:00:00.000' AS DateTime), CAST(N'2024-03-17T00:00:00.000' AS DateTime), N'101-A5                                                                                              ', N'1         ', N'3         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.219.3                                                                                           ', N'N07                                                                                                 ', CAST(N'2024-02-29T00:00:00.000' AS DateTime), CAST(N'2024-03-17T00:00:00.000' AS DateTime), N'101-A5                                                                                              ', N'1         ', N'5         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.219.3                                                                                           ', N'N07.BT                                                                                              ', CAST(N'2024-03-18T00:00:00.000' AS DateTime), CAST(N'2024-04-21T00:00:00.000' AS DateTime), N'101-A5                                                                                              ', N'1         ', N'3         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.219.3                                                                                           ', N'N07.TH                                                                                              ', CAST(N'2024-01-01T00:00:00.000' AS DateTime), CAST(N'2024-05-05T00:00:00.000' AS DateTime), NULL, NULL, NULL)
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.221.3                                                                                           ', N'N07                                                                                                 ', CAST(N'2024-01-01T00:00:00.000' AS DateTime), CAST(N'2024-01-28T00:00:00.000' AS DateTime), N'302-A5                                                                                              ', N'3         ', N'7         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.221.3                                                                                           ', N'N07                                                                                                 ', CAST(N'2024-02-19T00:00:00.000' AS DateTime), CAST(N'2024-04-07T00:00:00.000' AS DateTime), N'302-A5                                                                                              ', N'3         ', N'7         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.221.3                                                                                           ', N'N07.BT                                                                                              ', CAST(N'2024-04-08T00:00:00.000' AS DateTime), CAST(N'2024-04-14T00:00:00.000' AS DateTime), NULL, NULL, NULL)
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.221.3                                                                                           ', N'N07.BT                                                                                              ', CAST(N'2024-04-08T00:00:00.000' AS DateTime), CAST(N'2024-04-14T00:00:00.000' AS DateTime), N'302-A5                                                                                              ', N'3         ', N'5         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.221.3                                                                                           ', N'N07.BT                                                                                              ', CAST(N'2024-04-08T00:00:00.000' AS DateTime), CAST(N'2024-04-18T00:00:00.000' AS DateTime), N'302-A5                                                                                              ', N'3         ', N'7         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.221.3                                                                                           ', N'N07.BT                                                                                              ', CAST(N'2024-04-15T00:00:00.000' AS DateTime), CAST(N'2024-04-21T00:00:00.000' AS DateTime), N'302-A5                                                                                              ', N'3         ', N'7         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.221.3                                                                                           ', N'N07.BT                                                                                              ', CAST(N'2024-04-29T00:00:00.000' AS DateTime), CAST(N'2024-05-05T00:00:00.000' AS DateTime), N'302-A5                                                                                              ', N'3         ', N'5         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.221.3                                                                                           ', N'N07.TH                                                                                              ', CAST(N'2024-01-01T00:00:00.000' AS DateTime), CAST(N'2024-05-05T00:00:00.000' AS DateTime), NULL, NULL, NULL)
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.220.3                                                                                           ', N'N07                                                                                                 ', CAST(N'2024-01-01T00:00:00.000' AS DateTime), CAST(N'2024-01-28T00:00:00.000' AS DateTime), N'302-A5                                                                                              ', N'2         ', N'3         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.220.3                                                                                           ', N'N07                                                                                                 ', CAST(N'2024-01-01T00:00:00.000' AS DateTime), CAST(N'2024-01-28T00:00:00.000' AS DateTime), N'302-A5                                                                                              ', N'2         ', N'5         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.220.3                                                                                           ', N'N07                                                                                                 ', CAST(N'2024-02-19T00:00:00.000' AS DateTime), CAST(N'2024-03-10T00:00:00.000' AS DateTime), N'302-A5                                                                                              ', N'2         ', N'3         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.220.3                                                                                           ', N'N07.BT                                                                                              ', CAST(N'2024-03-11T00:00:00.000' AS DateTime), CAST(N'2024-04-21T00:00:00.000' AS DateTime), N'302-A5                                                                                              ', N'2         ', N'3         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.220.3                                                                                           ', N'N07.TH                                                                                              ', CAST(N'2024-01-01T00:00:00.000' AS DateTime), CAST(N'2024-05-05T00:00:00.000' AS DateTime), NULL, NULL, NULL)
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT.1.2024.333                                                                                       ', N'N34                                                                                                 ', CAST(N'2024-01-01T00:00:00.000' AS DateTime), CAST(N'2024-05-01T00:00:00.000' AS DateTime), N'401-A7                                                                                              ', N'3         ', N'2         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.12019.6                                                                                         ', N'N11                                                                                                 ', NULL, NULL, N'401-A5                                                                                              ', N'2         ', N'2         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'IT1.12019.6                                                                                         ', N'N11                                                                                                 ', CAST(N'2024-01-21T00:00:00.000' AS DateTime), CAST(N'2024-05-21T00:00:00.000' AS DateTime), N'401-A5                                                                                              ', N'2         ', N'2         ')
INSERT [dbo].[ChiTietTC] ([MaHP], [MaCTHP], [Start], [End], [Phong], [Ca], [Thu]) VALUES (N'12312                                                                                               ', N'N01                                                                                                 ', NULL, CAST(N'2024-05-01T00:00:00.000' AS DateTime), N'405-2                                                                                               ', N'1         ', N'2         ')
GO
INSERT [dbo].[HocPhan] ([MaHP], [TenHP], [SoTC], [SL], [SLDK]) VALUES (N'IT0.101.3                                                                                           ', N'Tiếng Anh Chuyên Ngành                                                                              ', N'3         ', 45, NULL)
INSERT [dbo].[HocPhan] ([MaHP], [TenHP], [SoTC], [SL], [SLDK]) VALUES (N'IT1.114.3                                                                                           ', N'Lập Trình Trực Quan                                                                                 ', N'3         ', 75, NULL)
INSERT [dbo].[HocPhan] ([MaHP], [TenHP], [SoTC], [SL], [SLDK]) VALUES (N'IT1.115.3                                                                                           ', N'Mạng Máy Tính                                                                                       ', N'3         ', 75, NULL)
INSERT [dbo].[HocPhan] ([MaHP], [TenHP], [SoTC], [SL], [SLDK]) VALUES (N'IT1.116.2                                                                                           ', N'Phân Tích Thiết Kế Yêu Cầu                                                                          ', N'2         ', 75, NULL)
INSERT [dbo].[HocPhan] ([MaHP], [TenHP], [SoTC], [SL], [SLDK]) VALUES (N'IT1.118.2                                                                                           ', N'Thuật Toán và Ứng Dụng                                                                              ', N'2         ', 75, NULL)
INSERT [dbo].[HocPhan] ([MaHP], [TenHP], [SoTC], [SL], [SLDK]) VALUES (N'IT1.2024.6                                                                                          ', N'Valorant1                                                                                           ', N'3         ', 45, NULL)
INSERT [dbo].[HocPhan] ([MaHP], [TenHP], [SoTC], [SL], [SLDK]) VALUES (N'IT1.217.3                                                                                           ', N'Lập Trình Web                                                                                       ', N'3         ', 120, NULL)
INSERT [dbo].[HocPhan] ([MaHP], [TenHP], [SoTC], [SL], [SLDK]) VALUES (N'IT1.219.3                                                                                           ', N'Lập Trình Thiết Bị Di Động                                                                          ', N'3         ', 75, NULL)
INSERT [dbo].[HocPhan] ([MaHP], [TenHP], [SoTC], [SL], [SLDK]) VALUES (N'IT1.220.3                                                                                           ', N'Trí Tuệ Nhân Tạo                                                                                    ', N'3         ', 75, NULL)
INSERT [dbo].[HocPhan] ([MaHP], [TenHP], [SoTC], [SL], [SLDK]) VALUES (N'IT1.221.3                                                                                           ', N'Phân Tích Thiết Kế Hướng Đối Tượng                                                                  ', N'3         ', 80, NULL)
INSERT [dbo].[HocPhan] ([MaHP], [TenHP], [SoTC], [SL], [SLDK]) VALUES (N'IT1.222.3                                                                                           ', N'An Toàn và Bảo Mật Thông Tin                                                                        ', N'3         ', 80, NULL)
INSERT [dbo].[HocPhan] ([MaHP], [TenHP], [SoTC], [SL], [SLDK]) VALUES (N'IT1.223.2                                                                                           ', N'Hệ Quản Trị Cơ Sở Dữ Liệu SQLServer                                                                 ', N'2         ', 150, NULL)
INSERT [dbo].[HocPhan] ([MaHP], [TenHP], [SoTC], [SL], [SLDK]) VALUES (N'IT1.226.3                                                                                           ', N'Lập Trình API                                                                                       ', N'3         ', 75, NULL)
INSERT [dbo].[HocPhan] ([MaHP], [TenHP], [SoTC], [SL], [SLDK]) VALUES (N'IT1.228.2                                                                                           ', N'Hệ Điều Hành Window Server                                                                          ', N'2         ', 75, NULL)
INSERT [dbo].[HocPhan] ([MaHP], [TenHP], [SoTC], [SL], [SLDK]) VALUES (N'IT120196                                                                                            ', N'Valdorant                                                                                           ', N'3         ', 45, 0)
INSERT [dbo].[HocPhan] ([MaHP], [TenHP], [SoTC], [SL], [SLDK]) VALUES (N'IT5.2024.16                                                                                         ', N'GenshinImpact                                                                                       ', N'4         ', 45, NULL)
INSERT [dbo].[HocPhan] ([MaHP], [TenHP], [SoTC], [SL], [SLDK]) VALUES (N'IT5.2024.199                                                                                        ', N'HonKai                                                                                              ', N'3         ', 45, NULL)
GO
INSERT [dbo].[KetQua] ([MaHP], [ID], [DiemQT], [DiemThi]) VALUES (N'IT1.219.3                                                                                           ', N'001                                                                                                 ', 9, 8)
GO
INSERT [dbo].[Khoa] ([MaKhoa], [TenKhoa]) VALUES (N'CT        ', N'Công Trình')
INSERT [dbo].[Khoa] ([MaKhoa], [TenKhoa]) VALUES (N'IT        ', N'CNTT      ')
INSERT [dbo].[Khoa] ([MaKhoa], [TenKhoa]) VALUES (N'XD        ', N'Xây Dựng  ')
GO
INSERT [dbo].[KQDK] ([ID], [MaHP], [IsDeleted]) VALUES (N'211240892                                                                                           ', N'IT1.220.3                                                                                           ', 0)
INSERT [dbo].[KQDK] ([ID], [MaHP], [IsDeleted]) VALUES (N'211240892                                                                                           ', N'IT1.219.3                                                                                           ', 0)
INSERT [dbo].[KQDK] ([ID], [MaHP], [IsDeleted]) VALUES (N'002                                                                                                 ', N'IT1.222.3                                                                                           ', NULL)
INSERT [dbo].[KQDK] ([ID], [MaHP], [IsDeleted]) VALUES (N'002                                                                                                 ', N'IT1.219.3                                                                              IT1.222.3    ', NULL)
INSERT [dbo].[KQDK] ([ID], [MaHP], [IsDeleted]) VALUES (N'003                                                                                                 ', N'IT1.219.3                                                                                           ', NULL)
GO
INSERT [dbo].[LichThi] ([ID], [MaHP], [NgayThi], [ThoiGian], [HinhThuc], [PhongThi], [SBD]) VALUES (N'211240892                                                                                           ', N'IT1.226.4                                                                                           ', CAST(N'2024-05-30' AS Date), N'13:00-17:00                                                                                         ', N'Thực Hành                                                                                           ', N'404-A4    ', N'56        ')
INSERT [dbo].[LichThi] ([ID], [MaHP], [NgayThi], [ThoiGian], [HinhThuc], [PhongThi], [SBD]) VALUES (N'211240892                                                                                           ', N'IT1.228.2                                                                                           ', CAST(N'2024-05-25' AS Date), N'13:00-17:00                                                                                         ', N'Thực Hành                                                                                           ', N'506-A4    ', N'135       ')
INSERT [dbo].[LichThi] ([ID], [MaHP], [NgayThi], [ThoiGian], [HinhThuc], [PhongThi], [SBD]) VALUES (N'211240892                                                                                           ', N'IT1.222.3                                                                                           ', CAST(N'2024-05-23' AS Date), N'07:00-09:00                                                                                         ', N'Tự Luận                                                                                             ', N'307-A8    ', N'152       ')
INSERT [dbo].[LichThi] ([ID], [MaHP], [NgayThi], [ThoiGian], [HinhThuc], [PhongThi], [SBD]) VALUES (N'211240892                                                                                           ', N'IT1.221.3                                                                                           ', CAST(N'2024-05-20' AS Date), N'07:00-11:00                                                                                         ', N'Báo Cáo 2                                                                                           ', N'208-A3    ', N'26        ')
INSERT [dbo].[LichThi] ([ID], [MaHP], [NgayThi], [ThoiGian], [HinhThuc], [PhongThi], [SBD]) VALUES (N'211240892                                                                                           ', N'IT1.219.3                                                                                           ', CAST(N'2024-05-17' AS Date), N'07:00-11:00                                                                                         ', N'Thực Hành                                                                                           ', N'407-A4    ', N'236       ')
INSERT [dbo].[LichThi] ([ID], [MaHP], [NgayThi], [ThoiGian], [HinhThuc], [PhongThi], [SBD]) VALUES (N'211240892                                                                                           ', N'IT1.220.3                                                                                           ', CAST(N'2024-05-14' AS Date), N'13:00-15:00                                                                                         ', N'Tự Luận                                                                                             ', N'304-A2    ', N'212       ')
GO
INSERT [dbo].[NienKhoa] ([Khoa], [Start]) VALUES (N'1                                                                             1                     ', N'1960                                                                                                ')
INSERT [dbo].[NienKhoa] ([Khoa], [Start]) VALUES (N'59                                                                                                  ', N'2018                                                                                                ')
INSERT [dbo].[NienKhoa] ([Khoa], [Start]) VALUES (N'60                                                                                                  ', N'2019                                                                                                ')
INSERT [dbo].[NienKhoa] ([Khoa], [Start]) VALUES (N'61                                                                                                  ', N'2020                                                                                                ')
INSERT [dbo].[NienKhoa] ([Khoa], [Start]) VALUES (N'62                                                                                                  ', N'2021                                                                                                ')
INSERT [dbo].[NienKhoa] ([Khoa], [Start]) VALUES (N'63                                                                                                  ', N'2022                                                                                                ')
INSERT [dbo].[NienKhoa] ([Khoa], [Start]) VALUES (N'64                                                                                                  ', N'2023                                                                                                ')
GO
INSERT [dbo].[SinhVien] ([ID], [HoTen], [GioiTinh], [NgaySinh], [SDT], [DiaChi], [Email], [MaKhoa], [Khoa]) VALUES (N'2112113737                                                                                          ', N'Dinh Cong Tien                                                                                      ', 1, N'Jan 29 2003 12:00AM                                                                                 ', N'0397930982                                                                                          ', N'Lai Chau                                                                                            ', NULL, N'IT                                                                                                  ', N'62        ')
INSERT [dbo].[SinhVien] ([ID], [HoTen], [GioiTinh], [NgaySinh], [SDT], [DiaChi], [Email], [MaKhoa], [Khoa]) VALUES (N'211211383                                                                                           ', N'Dinh Cong Tien                                                                                      ', 1, N'Jan 20 2003 12:00AM                                                                                 ', N'03912312                                                                                            ', N'ha noi                                                                                              ', NULL, N'IT                                                                                                  ', N'62        ')
INSERT [dbo].[SinhVien] ([ID], [HoTen], [GioiTinh], [NgaySinh], [SDT], [DiaChi], [Email], [MaKhoa], [Khoa]) VALUES (N'211214539                                                                                           ', N'Cong Cuong                                                                                          ', 1, N'Sep 27 2003 12:00AM                                                                                 ', N'0338989072                                                                                          ', N'Ha Noi                                                                                              ', NULL, N'IT                                                                                                  ', N'62        ')
INSERT [dbo].[SinhVien] ([ID], [HoTen], [GioiTinh], [NgaySinh], [SDT], [DiaChi], [Email], [MaKhoa], [Khoa]) VALUES (N'211240892                                                                                           ', N'HiuTao                                                                                              ', 1, N'Jan  1 1990 12:00AM                                                                                 ', N'123456789                                                                                           ', N'123 Main                                                                                            ', N'hiutao007@gmail.com                                                                                 ', N'IT                                                                                                  ', N'63        ')
INSERT [dbo].[SinhVien] ([ID], [HoTen], [GioiTinh], [NgaySinh], [SDT], [DiaChi], [Email], [MaKhoa], [Khoa]) VALUES (N'211242642                                                                                           ', N'Do Duy An                                                                                           ', 1, N'Aug 28 2003 12:00AM                                                                                 ', N'01231231123                                                                                         ', N'Viet Nam                                                                                            ', NULL, N'IT                                                                                                  ', N'62        ')
INSERT [dbo].[SinhVien] ([ID], [HoTen], [GioiTinh], [NgaySinh], [SDT], [DiaChi], [Email], [MaKhoa], [Khoa]) VALUES (N'212312931                                                                                           ', N'Nguyen Tran Cuong                                                                                   ', 1, N'Feb  1 2003 12:00AM                                                                                 ', N'0193123123                                                                                          ', N'Ha Noi                                                                                              ', NULL, N'IT                                                                                                  ', N'63        ')
INSERT [dbo].[SinhVien] ([ID], [HoTen], [GioiTinh], [NgaySinh], [SDT], [DiaChi], [Email], [MaKhoa], [Khoa]) VALUES (N'376267123                                                                                           ', N'Duy Eng                                                                                             ', 1, N'Jan  1 2003 12:00AM                                                                                 ', N'092131231                                                                                           ', N'Ha noi                                                                                              ', NULL, N'IT                                                                                                  ', N'63        ')
GO
INSERT [dbo].[TKSinhVien] ([ID], [PassWordSV]) VALUES (N'212312931                                                                                           ', N'123456                                                                                              ')
INSERT [dbo].[TKSinhVien] ([ID], [PassWordSV]) VALUES (N'2112113737                                                                                          ', N'123456                                                                                              ')
INSERT [dbo].[TKSinhVien] ([ID], [PassWordSV]) VALUES (N'376267123                                                                                           ', N'123456                                                                                              ')
INSERT [dbo].[TKSinhVien] ([ID], [PassWordSV]) VALUES (N'211240892                                                                                           ', N'123                                                                                                 ')
INSERT [dbo].[TKSinhVien] ([ID], [PassWordSV]) VALUES (N'211211383                                                                                           ', N'123456                                                                                              ')
INSERT [dbo].[TKSinhVien] ([ID], [PassWordSV]) VALUES (N'211214539                                                                                           ', N'123456                                                                                              ')
INSERT [dbo].[TKSinhVien] ([ID], [PassWordSV]) VALUES (N'211242642                                                                                           ', N'123456                                                                                              ')
GO
/****** Object:  StoredProcedure [dbo].[changePassword]    Script Date: 5/8/2024 5:36:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[changePassword] @newpass nvarchar(50),@username nvarchar(50), @password nvarchar(50) as 
begin
	declare @id nvarchar(100)
	set @id = (select [TKSinhVien].ID
				from [TKSinhVien] inner join SinhVien on SinhVien.ID = [TKSinhVien].ID
				where [TKSinhVien].ID = @username and [TKSinhVien].PassWordSV = @password)
	update [TKSinhVien]
	set PassWordSV = @newpass
	where ID = @id
end
GO
/****** Object:  StoredProcedure [dbo].[changeProfile]    Script Date: 5/8/2024 5:36:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create PROCEDURE [dbo].[changeProfile]
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
GO
/****** Object:  StoredProcedure [dbo].[get_KQDK_by_ID]    Script Date: 5/8/2024 5:36:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[get_KQDK_by_ID] @id nvarchar(100) as begin
	select distinct HocPhan.MaHP, HocPhan.TenHP, ChiTietTC.MaCTHP, 
	ChiTietTC.[Start], ChiTietTC.[End], ChiTietTC.Ca, ChiTietTC.Thu
	from HocPhan inner join ChiTietTC on HocPhan.MaHP = ChiTietTC.MaHP 
	inner join KQDK on KQDK.MaHP = HocPhan.MaHP
	where KQDK.ID = @id
end
GO
/****** Object:  StoredProcedure [dbo].[get_LichHoc]    Script Date: 5/8/2024 5:36:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[get_LichHoc] @id nvarchar(100) as begin
	select distinct HocPhan.MaHP, HocPhan.TenHP, ChiTietTC.MaCTHP, 
	ChiTietTC.[Start], ChiTietTC.[End], ChiTietTC.Ca, ChiTietTC.Thu
	from HocPhan inner join ChiTietTC on HocPhan.MaHP = ChiTietTC.MaHP 
	inner join KQDK on KQDK.MaHP = HocPhan.MaHP
	where KQDK.ID = @id and '2024-2-8' between ChiTietTC.Start and ChiTietTC.[End]
end
GO
/****** Object:  StoredProcedure [dbo].[getDetailCourse]    Script Date: 5/8/2024 5:36:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getDetailCourse] @mahp nvarchar(100) as
begin
	select distinct HocPhan.MaHP, HocPhan.TenHP, ChiTietTC.MaCTHP, ChiTietTC.[Start], ChiTietTC.[End],ChiTietTC.Phong, ChiTietTC.Ca, ChiTietTC.Thu
	from HocPhan inner join ChiTietTC on HocPhan.MaHP = ChiTietTC.MaHP
	where HocPhan.MaHP = @mahp
end
GO
/****** Object:  StoredProcedure [dbo].[getInfo]    Script Date: 5/8/2024 5:36:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getInfo] @username nvarchar(50), @password nvarchar(50) as
begin
	select HoTen, SinhVien.Email
	from [Admin] inner join SinhVien on SinhVien.ID = [Admin].ID
	where [Admin].UserName = @username and [Admin].Password = @password
end
GO
/****** Object:  StoredProcedure [dbo].[getInfoByID]    Script Date: 5/8/2024 5:36:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getInfoByID] @id nchar(100) as begin
	select HoTen, NgaySinh, SDT, DiaChi, Email
	from SinhVien
	where ID = @id
end
GO
/****** Object:  StoredProcedure [dbo].[getLichThi]    Script Date: 5/8/2024 5:36:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getLichThi] @id nvarchar(100) as begin
	select LichThi.ID, HocPhan.MaHP,HocPhan.TenHP, LichThi.NgayThi, LichThi.ThoiGian, LichThi.HinhThuc, LichThi.PhongThi, LichThi.SBD
	from LichThi inner join HocPhan on HocPhan.MaHP = LichThi.MaHP
	where LichThi.ID = @id
end
GO
/****** Object:  StoredProcedure [dbo].[getListCourse]    Script Date: 5/8/2024 5:36:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getListCourse] as
begin
	select distinct HocPhan.MaHP, HocPhan.TenHP, HocPhan.TenHP, HocPhan.SL, HocPhan.SLDK, HocPhan.SoTC
	from HocPhan inner join ChiTietTC on HocPhan.MaHP = ChiTietTC.MaHP
end
GO
/****** Object:  StoredProcedure [dbo].[getUser]    Script Date: 5/8/2024 5:36:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getUser] @user nvarchar(50), @pass nvarchar(50)
as
begin
	select * from Admin 
	where @user = Admin.UserName and @pass = Admin.PassWord
end
GO
/****** Object:  StoredProcedure [dbo].[insertKQDK]    Script Date: 5/8/2024 5:36:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create PROCEDURE [dbo].[insertKQDK] 
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
GO
/****** Object:  StoredProcedure [dbo].[updateKQDK]    Script Date: 5/8/2024 5:36:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[updateKQDK] @mahp nvarchar(100) as begin
	UPDATE HocPhan
		SET SLDK = SLDK + 1
		WHERE MaHP = @mahp
end
GO
USE [master]
GO
ALTER DATABASE [QLSV] SET  READ_WRITE 
GO
