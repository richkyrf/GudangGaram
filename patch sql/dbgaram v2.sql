-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 09, 2018 at 06:53 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbgaram`
--
CREATE DATABASE IF NOT EXISTS `dbgaram` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `dbgaram`;

-- --------------------------------------------------------

--
-- Table structure for table `tbabsen`
--

CREATE TABLE `tbabsen` (
  `IdAbsen` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `IdKaryawan` int(11) NOT NULL,
  `Hadir` tinyint(1) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbhistory`
--

CREATE TABLE `tbhistory` (
  `Username` varchar(50) NOT NULL,
  `Activity` varchar(50) NOT NULL,
  `DateAndTime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbhistory`
--

INSERT INTO `tbhistory` (`Username`, `Activity`, `DateAndTime`) VALUES
('null', 'Berhasil menghapus  data Karyawan', '2018-02-06 10:46:51'),
('null', 'Berhasil menghapus  data Karyawan', '2018-02-06 10:46:55'),
('null', 'Berhasil menghapus  data Karyawan', '2018-02-06 10:46:58'),
('null', 'Berhasil menghapus  data Karyawan', '2018-02-06 10:47:01'),
('null', ' Multi Insert', '2018-02-07 15:49:56'),
('null', ' Multi Insert', '2018-02-07 15:49:56'),
('null', ' Multi Insert', '2018-02-07 15:49:57'),
('null', ' Multi Insert', '2018-02-07 15:49:57'),
('null', ' Multi Insert', '2018-02-07 15:50:47'),
('null', ' Multi Insert', '2018-02-07 15:50:47'),
('null', ' Multi Insert', '2018-02-07 15:50:47'),
('null', ' Multi Insert', '2018-02-07 15:50:47'),
('null', ' Multi Insert', '2018-02-07 16:05:15'),
('null', ' Multi Insert', '2018-02-07 16:05:15'),
('', 'StokHarian', '2018-02-07 16:05:29'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-08 13:31:47'),
('', 'Berhasil Penerimaan', '2018-02-08 14:09:45'),
('', 'Berhasil Barang', '2018-02-08 15:30:27'),
('', 'Berhasil Tambah Data Pemasok', '2018-02-09 09:40:59'),
('', 'Berhasil Tambah Data Pemasok', '2018-02-09 09:42:15'),
('', 'Berhasil Tambah Data Barang', '2018-02-09 09:42:37'),
('', 'Berhasil Tambah Data Barang', '2018-02-09 09:43:02');

-- --------------------------------------------------------

--
-- Table structure for table `tbmbarang`
--

CREATE TABLE `tbmbarang` (
  `IdBarang` int(11) NOT NULL,
  `AliasBarang` varchar(50) NOT NULL,
  `NamaBarang` varchar(80) NOT NULL,
  `IdJenisBarang` int(11) NOT NULL,
  `IdPemasok` int(11) DEFAULT NULL,
  `Satuan` decimal(11,2) NOT NULL,
  `Harga` int(11) NOT NULL,
  `UpahPacking` int(11) NOT NULL,
  `Keterangan` varchar(255) NOT NULL,
  `Status` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmbarang`
--

INSERT INTO `tbmbarang` (`IdBarang`, `AliasBarang`, `NamaBarang`, `IdJenisBarang`, `IdPemasok`, `Satuan`, `Harga`, `UpahPacking`, `Keterangan`, `Status`) VALUES
(1, 'G.K NON YOD BAHAN', 'GRM KSR NON YOD BAHAN', 1, 1, '50.00', 0, 0, '', 1),
(2, 'G.H YOD BAHAN', 'GRM HALUS YODIUM BAHAN', 1, NULL, '50.00', 0, 0, '', 1),
(3, 'G.K NON YOD 50 KG', 'GRM KSR NON YOD @50KG', 2, NULL, '50.00', 0, 0, '', 1),
(4, 'G.K NON YOD 5 KG', 'G. KASAR NON YOD @5KG', 2, NULL, '50.00', 0, 0, '\n', 1),
(5, 'G.H YOD 50 KG', 'GARAM HALUS YOD @50KG', 2, NULL, '50.00', 0, 0, '\n', 1),
(6, 'G.KOTOR 50KG', 'GARAM KOTOR @50KG', 2, NULL, '50.00', 0, 0, '\n', 1),
(7, 'G.K 1KG', 'GARAM KASAR @1KG', 2, NULL, '10.00', 50000, 450, '\n', 1),
(8, 'G.K 1/4 KG (20)', 'G. KASAR 1/4 KG @5KG', 2, NULL, '5.00', 30500, 490, '\n', 1),
(9, 'G.K 8 ONS', 'GARAM KASAR 8 ONS', 2, NULL, '8.00', 48000, 400, '\n', 1),
(10, 'G.K 1/2 KG', 'GARAM KASAR 1/2KG', 2, NULL, '10.00', 61000, 600, '\n', 1),
(11, 'G.K 1/4 KG (40)', 'G. KASAR 1/4KG @10KG', 2, NULL, '10.00', 60000, 950, '\n', 1),
(12, 'G.H 150 GR', 'GARAM HALUS 150 GRAM', 2, NULL, '7.50', 51500, 1175, '\n', 1),
(13, 'G.H 1/4 KG', 'GARAM HALUS 1/4KG', 2, NULL, '10.00', 63500, 1030, '\n', 1),
(14, 'G.H 1/2 KG', 'GARAM HALUS 1/2 KG', 2, NULL, '10.00', 63500, 700, '\n', 1),
(15, 'G.H 800 ONS', 'GARAM HALUS 8 ONS', 2, NULL, '0.80', 60000, 450, '\n', 1),
(16, 'G.H 1 KG', 'GARAM HALUS 1 KG', 2, NULL, '1.00', 62500, 530, '\n', 1),
(17, 'G.K PERSERO', 'GARAM KASAR PERSERO', 1, 2, '50.00', 0, 0, '\n', 1),
(18, 'G.K MEDAN', 'GARAM KASAR MEDAN', 1, 3, '50.00', 0, 0, '', 1),
(19, '123321', '123321', 1, 1, '0.00', 0, 0, '', 1),
(20, '12321321321', 'adasdamartonoasda', 1, 5, '123.00', 123, 123, '', 1),
(21, '3123123', '12321321321321', 1, 4, '21321.00', 3, 3123, '', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbmgudang`
--

CREATE TABLE `tbmgudang` (
  `IdGudang` int(11) NOT NULL,
  `Gudang` varchar(50) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmgudang`
--

INSERT INTO `tbmgudang` (`IdGudang`, `Gudang`, `Keterangan`) VALUES
(1, 'PAAL 5', ''),
(2, 'TALANGDUKU', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbmkaryawan`
--

CREATE TABLE `tbmkaryawan` (
  `IdKaryawan` int(11) NOT NULL,
  `NamaKaryawan` varchar(50) NOT NULL,
  `IdJenisKaryawan` int(11) NOT NULL,
  `Keterangan` varchar(255) NOT NULL,
  `Status` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmkaryawan`
--

INSERT INTO `tbmkaryawan` (`IdKaryawan`, `NamaKaryawan`, `IdJenisKaryawan`, `Keterangan`, `Status`) VALUES
(1, 'MUSLIM', 1, '', 1),
(2, 'SAHRUL', 1, '\n', 1),
(3, 'DEDI. S', 1, '\n', 1),
(4, 'OKTI. F', 1, '\n', 1),
(5, 'HERMAN', 1, '\n', 1),
(6, 'HASAN', 1, '\n', 1),
(7, 'MAHMUD', 1, '', 1),
(8, 'AMBAR', 2, '', 1),
(9, 'MUSLINA', 2, '', 1),
(10, 'SINAP', 2, '', 1),
(11, 'KAYATI', 2, '', 1),
(12, 'NILA', 2, '', 1),
(13, 'MISTIA', 2, '\n', 1),
(14, 'SUSILAWATI', 2, '\n', 1),
(15, 'MARTINA', 2, '\n', 1),
(16, 'TANIA', 2, '\n', 1),
(17, 'EKA', 2, '\n', 1),
(18, 'NETI', 2, '\n', 1),
(19, 'PUTRI', 2, '\n', 1),
(20, 'FITRI', 2, '\n', 1),
(21, 'NISWARI', 2, '\n', 1),
(22, 'BAITI', 2, '\n', 1),
(23, 'DESMIATI', 2, '\n', 1),
(25, 'SIMOR', 2, '\n', 1),
(26, 'RANI', 2, '\n', 1),
(27, 'ENI KUSUMA', 2, '\n', 1),
(28, 'AZIMA', 2, '\n', 1),
(29, 'SANTI', 2, '\n', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbmkendaraan`
--

CREATE TABLE `tbmkendaraan` (
  `IdKendaraan` int(11) NOT NULL,
  `Plat` varchar(12) NOT NULL,
  `JenisKendaraan` varchar(50) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmkendaraan`
--

INSERT INTO `tbmkendaraan` (`IdKendaraan`, `Plat`, `JenisKendaraan`, `Keterangan`) VALUES
(1, 'BM 8119 CI', 'L300', ''),
(2, 'BH 8846 MB', 'BOX', ''),
(3, 'BH 1 PLT', 'LAND HUD', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbmpemasok`
--

CREATE TABLE `tbmpemasok` (
  `IdPemasok` int(11) NOT NULL,
  `Pemasok` varchar(50) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmpemasok`
--

INSERT INTO `tbmpemasok` (`IdPemasok`, `Pemasok`, `Keterangan`) VALUES
(1, 'PT. GARINDO', ''),
(2, 'PT. PERSERO', ''),
(3, 'MEDAN', ''),
(4, 'asddsaasd', ''),
(5, '159753', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbmpeminta`
--

CREATE TABLE `tbmpeminta` (
  `IdPeminta` int(11) NOT NULL,
  `Peminta` varchar(50) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmpeminta`
--

INSERT INTO `tbmpeminta` (`IdPeminta`, `Peminta`, `Keterangan`) VALUES
(1, 'PT. INTI GARAM CEMERLANG', ''),
(2, 'Jarkasih', ''),
(3, 'William', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbmpenerima`
--

CREATE TABLE `tbmpenerima` (
  `IdPenerima` int(11) NOT NULL,
  `Penerima` varchar(50) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmpenerima`
--

INSERT INTO `tbmpenerima` (`IdPenerima`, `Penerima`, `Keterangan`) VALUES
(1, 'JASRIL', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbmutasi`
--

CREATE TABLE `tbmutasi` (
  `IdMutasi` int(11) NOT NULL,
  `Tanggal` int(11) NOT NULL,
  `IdBarang` int(11) NOT NULL,
  `Jumlah` decimal(11,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbpacking`
--

CREATE TABLE `tbpacking` (
  `IdPacking` int(11) NOT NULL,
  `NoPacking` varchar(20) NOT NULL,
  `Tanggal` datetime NOT NULL,
  `NoBak` int(11) NOT NULL,
  `NoPas` int(11) NOT NULL,
  `NoIndi` int(11) NOT NULL,
  `IdKaryawan` int(11) NOT NULL,
  `IdBarangBahan` int(11) NOT NULL,
  `JumlahBahan` decimal(11,2) NOT NULL,
  `IdBarangHasil` int(11) NOT NULL,
  `JumlahHasil` decimal(11,2) NOT NULL,
  `UpahPerPak` int(11) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbpacking`
--

INSERT INTO `tbpacking` (`IdPacking`, `NoPacking`, `Tanggal`, `NoBak`, `NoPas`, `NoIndi`, `IdKaryawan`, `IdBarangBahan`, `JumlahBahan`, `IdBarangHasil`, `JumlahHasil`, `UpahPerPak`, `Keterangan`) VALUES
(1, 'GG-000001-PG', '2018-02-07 00:00:00', 1, 1, 1, 8, 1, '6.50', 8, '42.50', 490, ''),
(2, 'GG-000001-PG', '2018-02-07 00:00:00', 1, 1, 2, 9, 1, '6.50', 8, '42.50', 490, ''),
(3, 'GG-000001-PG', '2018-02-07 00:00:00', 1, 2, 3, 10, 1, '6.50', 8, '30.00', 490, ''),
(4, 'GG-000001-PG', '2018-02-07 00:00:00', 1, 2, 4, 11, 1, '6.50', 8, '30.00', 490, ''),
(5, 'GG-000002-PG', '2018-02-07 00:00:00', 2, 3, 1, 12, 1, '6.50', 8, '40.00', 490, ''),
(6, 'GG-000002-PG', '2018-02-07 00:00:00', 2, 3, 2, 13, 1, '6.50', 8, '40.00', 490, ''),
(7, 'GG-000002-PG', '2018-02-07 00:00:00', 2, 4, 3, 14, 1, '6.50', 8, '30.00', 490, ''),
(8, 'GG-000002-PG', '2018-02-07 00:00:00', 2, 4, 4, 15, 1, '6.50', 8, '30.00', 490, '');

-- --------------------------------------------------------

--
-- Table structure for table `tbpenerimaan`
--

CREATE TABLE `tbpenerimaan` (
  `IdPenerimaan` int(11) NOT NULL,
  `NoPenerimaan` varchar(12) NOT NULL,
  `Tanggal` datetime NOT NULL,
  `IdPemasok` int(11) NOT NULL,
  `IdPeminta` int(11) NOT NULL,
  `IdBarang` int(11) NOT NULL,
  `KarungPenjual` int(11) NOT NULL,
  `NettoPenjual` int(11) NOT NULL,
  `NoTimbang` varchar(15) NOT NULL,
  `Plat` varchar(11) NOT NULL,
  `KarungPelita` int(11) NOT NULL,
  `BruttoPelita` int(11) NOT NULL,
  `TaraPelita` int(11) NOT NULL,
  `NettoPelita` int(11) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbpenerimaan`
--

INSERT INTO `tbpenerimaan` (`IdPenerimaan`, `NoPenerimaan`, `Tanggal`, `IdPemasok`, `IdPeminta`, `IdBarang`, `KarungPenjual`, `NettoPenjual`, `NoTimbang`, `Plat`, `KarungPelita`, `BruttoPelita`, `TaraPelita`, `NettoPelita`, `Keterangan`) VALUES
(1, 'GG-000001-PG', '2018-02-08 00:00:00', 1, 1, 1, 196, 10000, '377101', 'BH 1 PLT', 196, 40000, 30000, 10000, '');

-- --------------------------------------------------------

--
-- Table structure for table `tbpenjualan`
--

CREATE TABLE `tbpenjualan` (
  `IdPenjualan` int(11) NOT NULL,
  `NoTransaksi` varchar(20) NOT NULL,
  `Tanggal` datetime NOT NULL,
  `IdJenisPenjualan` int(11) NOT NULL,
  `IdKendaraan` int(11) NOT NULL,
  `IdGudang` int(11) DEFAULT NULL,
  `IdPenerima` int(11) DEFAULT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbpenjualan`
--

INSERT INTO `tbpenjualan` (`IdPenjualan`, `NoTransaksi`, `Tanggal`, `IdJenisPenjualan`, `IdKendaraan`, `IdGudang`, `IdPenerima`, `Keterangan`) VALUES
(1, 'GG-000001-PJ', '2018-02-07 00:00:00', 2, 2, NULL, 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `tbpenjualandetail`
--

CREATE TABLE `tbpenjualandetail` (
  `IdPenjualanDetail` int(11) NOT NULL,
  `NoTransaksi` varchar(20) NOT NULL,
  `NoKolom` int(11) NOT NULL,
  `IdBarang` int(11) NOT NULL,
  `Jumlah` int(11) NOT NULL,
  `HargaSatuan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbpenjualandetail`
--

INSERT INTO `tbpenjualandetail` (`IdPenjualanDetail`, `NoTransaksi`, `NoKolom`, `IdBarang`, `Jumlah`, `HargaSatuan`) VALUES
(1, 'GG-000001-PJ', 1, 8, 250, 30000);

-- --------------------------------------------------------

--
-- Table structure for table `tbpenyesuaian`
--

CREATE TABLE `tbpenyesuaian` (
  `IdPenyesuaian` int(11) NOT NULL,
  `NoPenyesuaian` varchar(20) NOT NULL,
  `Tanggal` date NOT NULL,
  `IdBarang` int(11) NOT NULL,
  `Sak` decimal(11,2) NOT NULL,
  `Jumlah` decimal(11,2) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbpoles`
--

CREATE TABLE `tbpoles` (
  `IdPoles` int(11) NOT NULL,
  `NoPoles` varchar(20) NOT NULL,
  `Tanggal` datetime NOT NULL,
  `Susut` int(11) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbpolesdetail`
--

CREATE TABLE `tbpolesdetail` (
  `IdPolesDetail` int(11) NOT NULL,
  `NoPoles` varchar(20) NOT NULL,
  `NoBahan` int(11) NOT NULL,
  `IdBarangBahan` int(11) NOT NULL,
  `JumlahBahan` int(11) NOT NULL,
  `SatuanBahan` varchar(15) NOT NULL,
  `KeteranganBahan` varchar(255) NOT NULL,
  `NoHasil` int(11) NOT NULL,
  `IdbarangHasil` int(11) NOT NULL,
  `JumlahHasil` int(11) NOT NULL,
  `SatuanHasil` varchar(15) NOT NULL,
  `KeteranganHasil` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbsmjenisbarang`
--

CREATE TABLE `tbsmjenisbarang` (
  `IdJenisBarang` int(11) NOT NULL,
  `JenisBarang` varchar(50) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbsmjenisbarang`
--

INSERT INTO `tbsmjenisbarang` (`IdJenisBarang`, `JenisBarang`, `Keterangan`) VALUES
(1, 'BAHAN', ''),
(2, 'HASIL', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbsmjeniskaryawan`
--

CREATE TABLE `tbsmjeniskaryawan` (
  `IdJenisKaryawan` int(11) NOT NULL,
  `JenisKaryawan` varchar(20) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbsmjeniskaryawan`
--

INSERT INTO `tbsmjeniskaryawan` (`IdJenisKaryawan`, `JenisKaryawan`, `Keterangan`) VALUES
(1, 'HARIAN', ''),
(2, 'BORONGAN', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbsmjenispenjualan`
--

CREATE TABLE `tbsmjenispenjualan` (
  `IdjenisPenjualan` int(11) NOT NULL,
  `JenisPenjualan` varchar(20) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbsmjenispenjualan`
--

INSERT INTO `tbsmjenispenjualan` (`IdjenisPenjualan`, `JenisPenjualan`, `Keterangan`) VALUES
(1, 'MUTASI GUDANG', ''),
(2, 'PENJUALAN', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbuser`
--

CREATE TABLE `tbuser` (
  `IdUser` int(10) NOT NULL,
  `Username` varchar(25) NOT NULL,
  `Password` varchar(32) NOT NULL,
  `Level` enum('Administrator','Operator') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbuser`
--

INSERT INTO `tbuser` (`IdUser`, `Username`, `Password`, `Level`) VALUES
(1, 'Admin', 'd41d8cd98f00b204e9800998ecf8427e', 'Administrator'),
(2, 'Martono', 'd41d8cd98f00b204e9800998ecf8427e', 'Operator'),
(3, '', 'd41d8cd98f00b204e9800998ecf8427e', 'Administrator'),
(4, 'Budi', 'd41d8cd98f00b204e9800998ecf8427e', 'Administrator'),
(5, 'Joko', 'd41d8cd98f00b204e9800998ecf8427e', 'Administrator'),
(6, 'Ani', 'd41d8cd98f00b204e9800998ecf8427e', 'Operator'),
(7, 'Fernanda', 'd41d8cd98f00b204e9800998ecf8427e', 'Operator'),
(12, 'Rudi', 'd41d8cd98f00b204e9800998ecf8427e', 'Administrator'),
(13, 'sdfsdfsdf', 'd41d8cd98f00b204e9800998ecf8427e', 'Administrator'),
(14, '123', 'd41d8cd98f00b204e9800998ecf8427e', 'Administrator');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbabsen`
--
ALTER TABLE `tbabsen`
  ADD PRIMARY KEY (`IdAbsen`);

--
-- Indexes for table `tbmbarang`
--
ALTER TABLE `tbmbarang`
  ADD PRIMARY KEY (`IdBarang`);

--
-- Indexes for table `tbmgudang`
--
ALTER TABLE `tbmgudang`
  ADD PRIMARY KEY (`IdGudang`);

--
-- Indexes for table `tbmkaryawan`
--
ALTER TABLE `tbmkaryawan`
  ADD PRIMARY KEY (`IdKaryawan`);

--
-- Indexes for table `tbmkendaraan`
--
ALTER TABLE `tbmkendaraan`
  ADD PRIMARY KEY (`IdKendaraan`);

--
-- Indexes for table `tbmpemasok`
--
ALTER TABLE `tbmpemasok`
  ADD PRIMARY KEY (`IdPemasok`);

--
-- Indexes for table `tbmpeminta`
--
ALTER TABLE `tbmpeminta`
  ADD PRIMARY KEY (`IdPeminta`);

--
-- Indexes for table `tbmpenerima`
--
ALTER TABLE `tbmpenerima`
  ADD PRIMARY KEY (`IdPenerima`);

--
-- Indexes for table `tbmutasi`
--
ALTER TABLE `tbmutasi`
  ADD PRIMARY KEY (`IdMutasi`);

--
-- Indexes for table `tbpacking`
--
ALTER TABLE `tbpacking`
  ADD PRIMARY KEY (`IdPacking`);

--
-- Indexes for table `tbpenerimaan`
--
ALTER TABLE `tbpenerimaan`
  ADD PRIMARY KEY (`IdPenerimaan`);

--
-- Indexes for table `tbpenjualan`
--
ALTER TABLE `tbpenjualan`
  ADD PRIMARY KEY (`IdPenjualan`);

--
-- Indexes for table `tbpenjualandetail`
--
ALTER TABLE `tbpenjualandetail`
  ADD PRIMARY KEY (`IdPenjualanDetail`);

--
-- Indexes for table `tbpenyesuaian`
--
ALTER TABLE `tbpenyesuaian`
  ADD PRIMARY KEY (`IdPenyesuaian`),
  ADD KEY `Penyesuaian` (`Jumlah`),
  ADD KEY `IdBarang` (`IdBarang`);

--
-- Indexes for table `tbpoles`
--
ALTER TABLE `tbpoles`
  ADD PRIMARY KEY (`IdPoles`);

--
-- Indexes for table `tbpolesdetail`
--
ALTER TABLE `tbpolesdetail`
  ADD PRIMARY KEY (`IdPolesDetail`);

--
-- Indexes for table `tbsmjenisbarang`
--
ALTER TABLE `tbsmjenisbarang`
  ADD PRIMARY KEY (`IdJenisBarang`);

--
-- Indexes for table `tbsmjeniskaryawan`
--
ALTER TABLE `tbsmjeniskaryawan`
  ADD PRIMARY KEY (`IdJenisKaryawan`);

--
-- Indexes for table `tbsmjenispenjualan`
--
ALTER TABLE `tbsmjenispenjualan`
  ADD PRIMARY KEY (`IdjenisPenjualan`);

--
-- Indexes for table `tbuser`
--
ALTER TABLE `tbuser`
  ADD PRIMARY KEY (`IdUser`),
  ADD UNIQUE KEY `Username` (`Username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbabsen`
--
ALTER TABLE `tbabsen`
  MODIFY `IdAbsen` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbmbarang`
--
ALTER TABLE `tbmbarang`
  MODIFY `IdBarang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `tbmgudang`
--
ALTER TABLE `tbmgudang`
  MODIFY `IdGudang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbmkaryawan`
--
ALTER TABLE `tbmkaryawan`
  MODIFY `IdKaryawan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
--
-- AUTO_INCREMENT for table `tbmkendaraan`
--
ALTER TABLE `tbmkendaraan`
  MODIFY `IdKendaraan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbmpemasok`
--
ALTER TABLE `tbmpemasok`
  MODIFY `IdPemasok` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `tbmpeminta`
--
ALTER TABLE `tbmpeminta`
  MODIFY `IdPeminta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbmpenerima`
--
ALTER TABLE `tbmpenerima`
  MODIFY `IdPenerima` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbmutasi`
--
ALTER TABLE `tbmutasi`
  MODIFY `IdMutasi` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbpacking`
--
ALTER TABLE `tbpacking`
  MODIFY `IdPacking` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `tbpenerimaan`
--
ALTER TABLE `tbpenerimaan`
  MODIFY `IdPenerimaan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbpenjualan`
--
ALTER TABLE `tbpenjualan`
  MODIFY `IdPenjualan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbpenjualandetail`
--
ALTER TABLE `tbpenjualandetail`
  MODIFY `IdPenjualanDetail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbpenyesuaian`
--
ALTER TABLE `tbpenyesuaian`
  MODIFY `IdPenyesuaian` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbpoles`
--
ALTER TABLE `tbpoles`
  MODIFY `IdPoles` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbpolesdetail`
--
ALTER TABLE `tbpolesdetail`
  MODIFY `IdPolesDetail` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbsmjenisbarang`
--
ALTER TABLE `tbsmjenisbarang`
  MODIFY `IdJenisBarang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbsmjeniskaryawan`
--
ALTER TABLE `tbsmjeniskaryawan`
  MODIFY `IdJenisKaryawan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbsmjenispenjualan`
--
ALTER TABLE `tbsmjenispenjualan`
  MODIFY `IdjenisPenjualan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbuser`
--
ALTER TABLE `tbuser`
  MODIFY `IdUser` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
