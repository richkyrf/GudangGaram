-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 22, 2018 at 11:01 AM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
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
('ADMIN', 'Berhasil Tambah Data Barang', '2018-02-20 14:41:05'),
('ADMIN', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 14:51:24'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:21:40'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:21:46'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:21:52'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:22:02'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:22:27'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:22:45'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:22:58'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:23:56'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:24:08'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:24:14'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:24:39'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:24:49'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:24:59'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:25:06'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:25:21'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:25:28'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:25:35'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:26:09'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:26:16'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:26:36'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:26:43'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:27:31'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:27:45'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-20 15:27:50'),
('', 'Berhasil Tambah Data Partai', '2018-02-20 15:31:25'),
('', 'Berhasil Ubah Data Partai', '2018-02-20 15:35:56'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-20 15:42:55'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-20 15:44:02'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-20 15:52:56'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-20 15:53:52'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-20 15:54:31'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-20 15:55:13'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-20 15:57:57'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-20 15:58:18'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-20 15:59:22'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-20 15:59:58'),
('', 'Berhasil Ubah Data Penerimaan', '2018-02-21 09:07:10'),
('', 'Berhasil Ubah Data Penerimaan', '2018-02-21 09:07:20'),
('', 'Berhasil Ubah Data Penerimaan', '2018-02-21 09:07:28'),
('', 'Berhasil Ubah Data Penerimaan', '2018-02-21 09:07:35'),
('', 'Berhasil Ubah Data Penerimaan', '2018-02-21 09:07:42'),
('', 'Berhasil Ubah Data Penerimaan', '2018-02-21 09:07:48'),
('', 'Berhasil Ubah Data Penerimaan', '2018-02-21 09:07:54'),
('', 'Berhasil Ubah Data Penerimaan', '2018-02-21 09:08:00'),
('', 'Berhasil Ubah Data Penerimaan', '2018-02-21 09:08:07'),
('', 'Berhasil Ubah Data Penerimaan', '2018-02-21 09:08:16'),
('', 'Berhasil Ubah Data Penerimaan', '2018-02-21 09:14:02'),
('', 'Berhasil Ubah Data Penerimaan', '2018-02-21 09:20:57'),
('', 'Berhasil Ubah Data Penerimaan', '2018-02-21 09:21:26'),
('', 'Berhasil Ubah Data Penerimaan', '2018-02-21 09:21:41'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:25:16'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:25:50'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:26:26'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:26:53'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:27:21'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:27:52'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:28:15'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:28:55'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:29:16'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:29:35'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:29:58'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:30:16'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:30:46'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:31:09'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:31:30'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:32:10'),
('', 'Berhasil Ubah Data Penerimaan', '2018-02-21 09:32:49'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:33:29'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:33:53'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:34:16'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:34:43'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:35:12'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:35:31'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:35:51'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:36:14'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:36:35'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:36:57'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:37:14'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:37:36'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:37:56'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:38:18'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:38:42'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:39:12'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:39:30'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:40:00'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:40:18'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:40:42'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:40:59'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:41:43'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:42:11'),
('', 'Berhasil Ubah DataPartai', '2018-02-21 09:42:12'),
('', 'Berhasil Menghapus Data Penerimaan', '2018-02-21 09:47:30'),
('', 'Berhasil Ubah Data Partai', '2018-02-21 09:47:50'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-21 09:48:23'),
('', 'Berhasil Ubah DataPartai', '2018-02-21 09:48:24'),
('', 'Berhasil Ubah Data Partai', '2018-02-21 10:04:12'),
('', 'Berhasil Ubah Data Penerimaan', '2018-02-21 10:41:11'),
('', 'Berhasil Ubah Data Penerimaan', '2018-02-21 10:45:24'),
('', 'Berhasil Tambah Data Penerima', '2018-02-21 14:17:34'),
('', 'Berhasil Menghapus Data Penerima', '2018-02-21 14:18:03'),
('', 'Berhasil Tambah Data Penyesuaian', '2018-02-22 11:58:41'),
('', 'Berhasil Tambah Data Penyesuaian', '2018-02-22 11:59:23'),
('', 'Berhasil Tambah Data Penyesuaian', '2018-02-22 12:00:08'),
('', 'Berhasil Tambah Data Penyesuaian', '2018-02-22 12:02:17'),
('', 'Berhasil Tambah Data Penyesuaian', '2018-02-22 12:03:05'),
('', 'Berhasil Tambah Data Penyesuaian', '2018-02-22 12:03:29'),
('', 'Berhasil Tambah Data Penyesuaian', '2018-02-22 12:03:51'),
('', 'Berhasil Tambah Data Penyesuaian', '2018-02-22 12:54:03'),
('', 'Berhasil Tambah Data Penyesuaian', '2018-02-22 12:56:29'),
('', 'Berhasil Tambah Data Penyesuaian', '2018-02-22 12:59:24'),
('', 'Berhasil Tambah Data Penyesuaian', '2018-02-22 13:00:20'),
('', 'Berhasil Tambah Data Penyesuaian', '2018-02-22 13:02:13'),
('', 'Berhasil Tambah Data Penyesuaian', '2018-02-22 13:48:28'),
('', 'Berhasil Tambah Data Penyesuaian', '2018-02-22 13:52:38'),
('', 'Berhasil Tambah Data Penyesuaian', '2018-02-22 13:53:30'),
('', 'Berhasil Tambah Data Penyesuaian', '2018-02-22 13:54:08'),
('', 'Berhasil Tambah Data Penyesuaian', '2018-02-22 15:00:42'),
('', 'Berhasil Tambah Data Penyesuaian', '2018-02-22 15:02:57'),
('', 'Berhasil Tambah Data Penyesuaian', '2018-02-22 15:04:03'),
('', 'Berhasil Tambah Data Penyesuaian', '2018-02-22 15:04:27'),
('', 'Berhasil Tambah Data Penyesuaian', '2018-02-22 15:11:32'),
('', 'Berhasil Tambah Data Partai', '2018-02-22 15:28:04'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:33:55'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:34:29'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-22 15:35:09'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:35:27'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-22 15:38:08'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:38:33'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:40:52'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:41:21'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:41:51'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:42:17'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-22 15:42:46'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:43:02'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:43:30'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:43:55'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:44:52'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:45:19'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:45:43'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:46:15'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:46:43'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:47:17'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:48:25'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:48:58'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:49:22'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-22 15:50:41'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:50:59'),
('', 'Berhasil Tambah Data Master Kendaraan', '2018-02-22 15:51:36'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:51:50'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:52:19'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:52:41'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:53:12'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:54:11'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:55:01'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:55:33'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:56:05'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:56:31'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 15:57:09'),
('', 'Berhasil Tambah Data Penerimaan', '2018-02-22 16:01:35');

-- --------------------------------------------------------

--
-- Table structure for table `tbmbarang`
--

CREATE TABLE `tbmbarang` (
  `IdBarang` int(11) NOT NULL,
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

INSERT INTO `tbmbarang` (`IdBarang`, `NamaBarang`, `IdJenisBarang`, `IdPemasok`, `Satuan`, `Harga`, `UpahPacking`, `Keterangan`, `Status`) VALUES
(1, 'GRM KSR NON YOD BHN GARINDO', 1, 1, '50.00', 0, 0, '', 1),
(2, 'GRM KSR NON YOD BHN PERSERO', 1, 2, '50.00', 0, 0, '', 1),
(3, 'GRM HLS YOD BHN', 1, 1, '50.00', 0, 0, '', 1),
(4, 'GRM KSR NON YOD @50 KG', 2, NULL, '50.00', 0, 0, '', 1),
(5, 'G. KOTOR @50 KG', 2, NULL, '50.00', 0, 0, '', 1),
(6, 'G. KASAR 1 KG', 2, NULL, '10.00', 50000, 450, '', 1),
(7, 'G. KASAR 1/4KG @5 KG', 2, NULL, '5.00', 30500, 490, '', 1),
(8, 'G. KASAR 8 ONS', 2, NULL, '8.00', 48000, 400, '', 1),
(9, 'G. KASAR 1/2 KG', 2, NULL, '10.00', 61000, 600, '', 1),
(10, 'G. HALUS 150 GRAM', 2, NULL, '7.50', 52000, 1175, '', 1),
(11, 'G. HALUS 1/4 KG', 2, NULL, '10.00', 63500, 1030, '', 1),
(12, 'G. HALUS 1/2 KG', 2, NULL, '10.00', 63500, 700, '', 1),
(13, 'G. HALUS 8 ONS', 2, NULL, '8.00', 60000, 450, '', 1),
(14, 'G. HALUS 1 KG', 2, NULL, '10.00', 62500, 530, '', 1);

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `tbmkendaraan`
--

INSERT INTO `tbmkendaraan` (`IdKendaraan`, `Plat`, `JenisKendaraan`, `Keterangan`) VALUES
(1, 'BM 8119 CI', 'L300', ''),
(2, 'BH 8846 MB', 'BOX', ''),
(3, 'BA 8850 BU', '-', ''),
(4, 'BG 8613 UD', '-', ''),
(5, 'BG 8231 UK', '-', ''),
(6, 'BG 8030 UA', '-', ''),
(7, 'BG 8156 E', '-', ''),
(8, 'BG 8154 RP', '-', ''),
(9, 'BG 8891 UW', '-', ''),
(10, 'BG 8121 JD', '-', ''),
(11, 'BG 8801 MJ', '-', ''),
(12, 'BG 8534 UC', '-', ''),
(13, 'BG 8055 LO', '-', ''),
(14, 'BG 8175 CH', '-', ''),
(15, 'BG 8842 MJ', '-', ''),
(16, 'BG 8198 AO', '-', ''),
(17, 'BG 8055 LQ', '-', ''),
(18, 'BG 4577 ML', '-', ''),
(19, 'BG 4041 MK', '-', ''),
(20, 'BG 8860 AC', '-', ''),
(23, 'BG 8298 UD', '-', ''),
(24, 'BG 8768 MI', '-', ''),
(27, 'BG 8151 MI', '-', ''),
(28, 'BG 8364 UE', '-', ''),
(31, 'BG 8063 UT', '-', ''),
(32, 'BG 8156 F', '-', ''),
(33, 'BG 8625 MO', '-', ''),
(35, 'BG 8703 UB', '-', ''),
(36, 'BG 8021 BB', '-', ''),
(37, 'BG 8518 UC', '-', ''),
(38, 'BG 8624 F', '-', ''),
(39, 'BG 8194 XR', '-', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbmpartai`
--

CREATE TABLE `tbmpartai` (
  `IdPartai` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `IdBarang` int(11) NOT NULL,
  `Netto` int(11) NOT NULL,
  `Karung` int(11) NOT NULL,
  `Keterangan` text NOT NULL,
  `SelesaiTerima` tinyint(1) NOT NULL DEFAULT '0',
  `SelesaiProduksi` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmpartai`
--

INSERT INTO `tbmpartai` (`IdPartai`, `Tanggal`, `IdBarang`, `Netto`, `Karung`, `Keterangan`, `SelesaiTerima`, `SelesaiProduksi`) VALUES
(1, '2017-12-10', 2, 324250, 6485, '', 0, 0),
(2, '2017-12-10', 1, 777500, 15550, '', 1, 0);

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
(2, 'PT. PERSERO', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbmpeminta`
--

CREATE TABLE `tbmpeminta` (
  `IdPeminta` int(11) NOT NULL,
  `Peminta` varchar(50) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `tbmpeminta`
--

INSERT INTO `tbmpeminta` (`IdPeminta`, `Peminta`, `Keterangan`) VALUES
(1, 'PT. INTI GARAM CEMERLANG', ''),
(2, 'WILLIAM', ''),
(3, 'JARKASIH', '');

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
  `NoPoles` varchar(20) NOT NULL,
  `NoPacking` varchar(20) NOT NULL,
  `Tanggal` datetime NOT NULL,
  `NoBak` int(11) NOT NULL,
  `NoPas` int(11) NOT NULL,
  `NoIndi` int(11) NOT NULL,
  `IdKaryawan` int(11) NOT NULL,
  `IdPartai` int(11) NOT NULL,
  `JumlahBahan` decimal(11,2) NOT NULL,
  `IdBarangHasil` int(11) NOT NULL,
  `JumlahHasil` decimal(11,2) NOT NULL,
  `UpahPerPak` int(11) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbpenerimaan`
--

CREATE TABLE `tbpenerimaan` (
  `IdPenerimaan` int(11) NOT NULL,
  `NoPenerimaan` varchar(12) NOT NULL,
  `Tanggal` datetime NOT NULL,
  `IdPartai` int(11) NOT NULL,
  `IdPeminta` int(11) NOT NULL,
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

INSERT INTO `tbpenerimaan` (`IdPenerimaan`, `NoPenerimaan`, `Tanggal`, `IdPartai`, `IdPeminta`, `KarungPenjual`, `NettoPenjual`, `NoTimbang`, `Plat`, `KarungPelita`, `BruttoPelita`, `TaraPelita`, `NettoPelita`, `Keterangan`) VALUES
(1, 'GG-000001-PG', '2017-12-12 00:00:00', 1, 1, 200, 10000, '2321', 'BG 4577 ML', 200, 17990, 8000, 9990, ''),
(2, 'GG-000001-PG', '2017-12-12 00:00:00', 1, 1, 200, 10000, '23324', 'BG 4041 MK', 200, 18060, 8000, 10060, ''),
(3, 'GG-000001-PG', '2017-12-12 00:00:00', 1, 1, 200, 10000, '23213', 'BG 8703 UB', 200, 17840, 8000, 9840, ''),
(4, 'GG-000001-PG', '2017-12-12 00:00:00', 1, 1, 204, 10000, '2323213', 'BG 8021 BB', 204, 17990, 8000, 9990, ''),
(5, 'GG-000002-PG', '2017-12-13 00:00:00', 1, 1, 190, 9250, '1321321', 'BG 8030 UA', 190, 17410, 8000, 9410, ''),
(6, 'GG-000002-PG', '2017-12-13 00:00:00', 1, 1, 190, 9250, '2432432', 'BG 8156 F', 190, 17240, 8000, 9240, ''),
(7, 'GG-000002-PG', '2017-12-13 00:00:00', 1, 1, 190, 9250, '4324', 'BG 8231 UK', 190, 17210, 8000, 9210, ''),
(8, 'GG-000003-PG', '2017-12-14 00:00:00', 1, 1, 206, 10000, '34234', 'BG 4577 ML', 206, 17910, 8000, 9910, ''),
(9, 'GG-000003-PG', '2017-12-14 00:00:00', 1, 1, 192, 9250, '2432432', 'BG 8860 AC', 192, 17320, 8000, 9320, ''),
(10, 'GG-000003-PG', '2017-12-14 00:00:00', 1, 1, 192, 9250, '324324', 'BG 8518 UC', 192, 17290, 8000, 9290, ''),
(11, 'GG-000003-PG', '2017-12-14 00:00:00', 1, 1, 206, 10000, '2322', 'BG 8703 UB', 206, 18160, 8000, 10160, ''),
(12, 'GG-000003-PG', '2017-12-14 00:00:00', 1, 1, 206, 10000, '324324', 'BG 8021 BB', 206, 17860, 8000, 9860, ''),
(13, 'GG-000004-PG', '2017-12-15 00:00:00', 1, 1, 192, 9250, '3432432', 'BG 8625 MO', 192, 17420, 8000, 9420, ''),
(14, 'GG-000005-PG', '2017-12-16 00:00:00', 1, 1, 184, 9000, '232131', 'BG 8231 UK', 184, 17030, 8000, 9030, ''),
(15, 'GG-000005-PG', '2017-12-16 00:00:00', 1, 1, 185, 9000, '223', 'BG 8063 UT', 185, 17050, 8000, 9050, ''),
(16, 'GG-000005-PG', '2017-12-16 00:00:00', 1, 1, 184, 9000, '232323', 'BG 8156 E', 184, 16930, 8000, 8930, ''),
(17, 'GG-000005-PG', '2017-12-16 00:00:00', 1, 1, 184, 9000, '132323', 'BG 8860 AC', 184, 16960, 8000, 8960, ''),
(18, 'GG-000005-PG', '2017-12-16 00:00:00', 1, 1, 184, 9000, '213213', 'BG 8518 UC', 184, 16910, 8000, 8910, ''),
(19, 'GG-000006-PG', '2017-12-18 00:00:00', 1, 1, 206, 10000, '32323', 'BG 8021 BB', 206, 18100, 8000, 10100, ''),
(20, 'GG-000006-PG', '2017-12-18 00:00:00', 1, 1, 206, 10000, '234324', 'BG 8703 UB', 206, 17920, 8000, 9920, ''),
(21, 'GG-000006-PG', '2017-12-18 00:00:00', 1, 1, 206, 10000, '21321', 'BG 4577 ML', 206, 18040, 8000, 10040, ''),
(22, 'GG-000007-PG', '2017-12-19 00:00:00', 1, 1, 208, 11000, '3242323', 'BG 8624 F', 208, 19110, 8000, 11110, ''),
(23, 'GG-000007-PG', '2017-12-19 00:00:00', 1, 1, 228, 11000, '34324', 'BG 8194 XR', 228, 18980, 8000, 10980, ''),
(24, 'GG-000007-PG', '2017-12-19 00:00:00', 1, 1, 197, 9500, '213123', 'BG 8625 MO', 197, 17580, 8000, 9580, ''),
(25, 'GG-000007-PG', '2017-12-19 00:00:00', 1, 1, 173, 8350, '34324', 'BG 8156 E', 173, 16160, 8000, 8160, ''),
(26, 'GG-000007-PG', '2017-12-19 00:00:00', 1, 1, 177, 8550, '34324', 'BG 8231 UK', 177, 16680, 8000, 8680, ''),
(27, 'GG-000007-PG', '2017-12-19 00:00:00', 1, 1, 173, 8350, '23132', 'BG 8518 UC', 173, 16460, 8000, 8460, ''),
(28, 'GG-000008-PG', '2017-12-20 00:00:00', 1, 1, 200, 9600, '123123', 'BG 8860 AC', 200, 17870, 8000, 9870, ''),
(29, 'GG-000008-PG', '2017-12-20 00:00:00', 1, 1, 198, 9500, '2324', 'BG 8063 UT', 198, 17610, 8000, 9610, ''),
(30, 'GG-000009-PG', '2017-12-22 00:00:00', 1, 1, 195, 9400, '332432', 'BG 8231 UK', 195, 17780, 8000, 9780, ''),
(31, 'GG-000009-PG', '2017-12-22 00:00:00', 1, 1, 178, 8570, '423432', 'BG 8156 F', 178, 16670, 8000, 8670, ''),
(32, 'GG-000009-PG', '2017-12-22 00:00:00', 1, 1, 195, 9400, '34324', 'BG 8625 MO', 195, 17550, 8000, 9550, ''),
(33, 'GG-000010-PG', '2017-12-15 00:00:00', 1, 1, 460, 22550, '1', 'BA 8850 BU', 460, 30550, 8000, 22550, ''),
(34, 'GG-000011-PG', '2018-01-10 00:00:00', 1, 1, 400, 19430, '2', 'BG 8613 UD', 400, 27420, 8000, 19420, ''),
(35, 'GG-000012-PG', '2018-01-11 00:00:00', 1, 1, 190, 9400, '3', 'BG 8231 UK', 190, 17340, 8000, 9340, ''),
(36, 'GG-000012-PG', '2018-01-11 00:00:00', 1, 1, 180, 8830, '4', 'BG 8030 UA', 180, 16790, 8000, 8790, ''),
(37, 'GG-000012-PG', '2018-01-11 00:00:00', 1, 1, 400, 19750, '5', 'BG 8154 RP', 400, 27840, 8000, 19840, ''),
(38, 'GG-000012-PG', '2018-01-11 00:00:00', 1, 1, 190, 9520, '6', 'BG 8156 E', 190, 17410, 8000, 9410, ''),
(39, 'GG-000013-PG', '2018-01-12 00:00:00', 1, 1, 420, 20520, '6', 'BG 8613 UD', 420, 28560, 8000, 20560, ''),
(40, 'GG-000014-PG', '2018-01-13 00:00:00', 1, 1, 400, 19450, '7', 'BG 8154 RP', 400, 27720, 8000, 19720, ''),
(41, 'GG-000014-PG', '2018-01-13 00:00:00', 1, 1, 190, 9190, '8', 'BG 8030 UA', 190, 17230, 8000, 9230, ''),
(42, 'GG-000014-PG', '2018-01-13 00:00:00', 1, 1, 420, 20380, '8', 'BG 8891 UW', 420, 28690, 8000, 20690, ''),
(43, 'GG-000015-PG', '2018-01-15 00:00:00', 1, 1, 410, 20110, '11', 'BG 8121 JD', 410, 28230, 8000, 20230, ''),
(44, 'GG-000015-PG', '2018-01-15 00:00:00', 1, 1, 420, 20470, '12', 'BG 8613 UD', 420, 28410, 8000, 20410, ''),
(45, 'GG-000015-PG', '2018-01-15 00:00:00', 1, 1, 420, 20610, '12', 'BG 8801 MJ', 420, 28700, 8000, 20700, ''),
(46, 'GG-000016-PG', '2018-01-16 00:00:00', 1, 1, 420, 20640, '13', 'BG 8891 UW', 420, 28710, 8000, 20710, ''),
(47, 'GG-000016-PG', '2018-01-16 00:00:00', 1, 1, 420, 20430, '15', 'BG 8534 UC', 420, 28700, 8000, 20700, ''),
(48, 'GG-000016-PG', '2018-01-16 00:00:00', 1, 1, 420, 19830, '16', 'BG 8055 LO', 420, 28670, 8000, 20670, ''),
(49, 'GG-000017-PG', '2018-01-17 00:00:00', 1, 1, 410, 19680, '17', 'BG 8121 JD', 410, 28000, 8000, 20000, ''),
(50, 'GG-000017-PG', '2018-01-17 00:00:00', 1, 1, 200, 9660, '18', 'BG 8175 CH', 200, 17670, 8000, 9670, ''),
(51, 'GG-000017-PG', '2018-01-17 00:00:00', 1, 1, 420, 20320, '19', 'BG 8613 UD', 420, 28330, 8000, 20330, ''),
(52, 'GG-000017-PG', '2018-01-17 00:00:00', 1, 1, 210, 10360, '20', 'BG 8842 MJ', 210, 18180, 8000, 10180, ''),
(53, 'GG-000018-PG', '2018-01-18 00:00:00', 1, 1, 430, 21070, '21', 'BG 8891 UW', 430, 29230, 8000, 21230, ''),
(54, 'GG-000018-PG', '2018-01-18 00:00:00', 1, 1, 420, 20460, '22', 'BG 8198 AO', 420, 28630, 8000, 20630, ''),
(55, 'GG-000018-PG', '2018-01-18 00:00:00', 1, 1, 420, 20560, '23', 'BG 8055 LQ', 420, 28720, 8000, 20720, ''),
(56, 'GG-000019-PG', '2018-01-19 00:00:00', 1, 1, 420, 20450, '24', 'BG 8613 UD', 420, 28470, 8000, 20470, ''),
(57, 'GG-000019-PG', '2018-01-19 00:00:00', 1, 1, 410, 20500, '25', 'BG 8121 JD', 410, 28060, 8000, 20060, ''),
(58, 'GG-000020-PG', '2018-01-20 00:00:00', 1, 1, 200, 9840, '16', 'BG 4577 ML', 200, 17830, 8000, 9830, ''),
(59, 'GG-000020-PG', '2018-01-20 00:00:00', 1, 1, 200, 9900, '1514325', 'BG 4041 MK', 200, 17770, 8000, 9770, ''),
(60, 'GG-000020-PG', '2018-01-20 00:00:00', 1, 1, 190, 9110, '1513', 'BG 8860 AC', 190, 17300, 8000, 9300, ''),
(61, 'GG-000020-PG', '2018-01-20 00:00:00', 1, 1, 190, 9290, '1531351', 'BG 8030 UA', 190, 17340, 8000, 9340, ''),
(62, 'GG-000020-PG', '2018-01-20 00:00:00', 1, 1, 420, 20570, '1,46E+11', 'BG 8891 UW', 420, 28620, 8000, 20620, ''),
(63, 'GG-000021-PG', '2018-01-22 00:00:00', 1, 1, 410, 19530, '159681651', 'BG 8121 JD', 410, 27750, 8000, 19750, ''),
(64, 'GG-000021-PG', '2018-01-22 00:00:00', 1, 1, 420, 20240, '1456814314', 'BG 8613 UD', 420, 28360, 8000, 20360, ''),
(65, 'GG-000021-PG', '2018-01-22 00:00:00', 1, 1, 420, 20600, '15613651', 'BG 8055 LQ', 420, 28600, 8000, 20600, ''),
(66, 'GG-000022-PG', '2018-01-23 00:00:00', 1, 1, 190, 9200, '1461651561', 'BG 8860 AC', 190, 17270, 8000, 9270, ''),
(67, 'GG-000022-PG', '2018-01-23 00:00:00', 1, 1, 190, 9340, '14561563', 'BG 8298 UD', 190, 17350, 8000, 9350, ''),
(68, 'GG-000022-PG', '2018-01-23 00:00:00', 1, 1, 190, 9310, '1968514568', 'BG 8768 MI', 190, 17320, 8000, 9320, ''),
(69, 'GG-000022-PG', '2018-01-23 00:00:00', 1, 1, 190, 9150, '1561968', 'BG 8231 UK', 190, 17230, 8000, 9230, ''),
(70, 'GG-000022-PG', '2018-01-23 00:00:00', 1, 1, 430, 20830, '891891489', 'BG 8891 UW', 430, 28910, 8000, 20910, ''),
(71, 'GG-000023-PG', '2018-01-24 00:00:00', 1, 1, 420, 20370, '89416341', 'BG 8613 UD', 420, 28420, 8000, 20420, ''),
(72, 'GG-000023-PG', '2018-01-24 00:00:00', 1, 1, 200, 9500, '15461546', 'BG 8151 MI', 200, 17660, 8000, 9660, ''),
(73, 'GG-000023-PG', '2018-01-24 00:00:00', 1, 1, 200, 10280, '148561456', 'BG 8364 UE', 200, 17610, 8000, 9610, ''),
(74, 'GG-000024-PG', '2018-01-25 00:00:00', 1, 1, 410, 19500, '5136136', 'BG 8121 JD', 410, 27560, 8000, 19560, ''),
(75, 'GG-000024-PG', '2018-01-25 00:00:00', 1, 1, 430, 20600, '156156', 'BG 8891 UW', 430, 28720, 8000, 20720, ''),
(76, 'GG-000024-PG', '2018-01-25 00:00:00', 1, 1, 200, 9630, '5189649568', 'BG 4041 MK', 200, 17830, 8000, 9830, ''),
(77, 'GG-000024-PG', '2018-01-25 00:00:00', 1, 1, 190, 9260, '1,50E+11', 'BG 8231 UK', 190, 17120, 8000, 9120, ''),
(78, 'GG-000024-PG', '2018-01-25 00:00:00', 1, 1, 190, 9060, '151563', 'BG 8860 AC', 190, 17060, 8000, 9060, ''),
(79, 'GG-000024-PG', '2018-01-25 00:00:00', 1, 1, 190, 9160, '4544', 'BG 8156 E', 190, 17240, 8000, 9240, ''),
(80, 'GG-000025-PG', '2018-01-27 00:00:00', 1, 1, 190, 8710, '1461356', 'BG 8231 UK', 190, 16970, 8000, 8970, ''),
(81, 'GG-000025-PG', '2018-01-27 00:00:00', 1, 1, 190, 8680, '15616', 'BG 8860 AC', 190, 16710, 8000, 8710, '');

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

-- --------------------------------------------------------

--
-- Table structure for table `tbpenjualandetail`
--

CREATE TABLE `tbpenjualandetail` (
  `IdPenjualanDetail` int(11) NOT NULL,
  `NoTransaksi` varchar(20) NOT NULL,
  `NoKolom` int(11) NOT NULL,
  `IdBarang` int(11) DEFAULT NULL,
  `IdPartai` int(11) DEFAULT NULL,
  `Jumlah` int(11) NOT NULL,
  `HargaSatuan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbpenyesuaian`
--

CREATE TABLE `tbpenyesuaian` (
  `IdPenyesuaian` int(11) NOT NULL,
  `NoPenyesuaian` varchar(20) NOT NULL,
  `Tanggal` date NOT NULL,
  `IdBarang` int(11) DEFAULT NULL,
  `IdPartai` int(11) DEFAULT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `tbuser`
--

INSERT INTO `tbuser` (`IdUser`, `Username`, `Password`, `Level`) VALUES
(-1, '', 'd41d8cd98f00b204e9800998ecf8427e', 'Administrator'),
(1, 'ADMIN', '81e9c94682d63a8a6204b77a690e331e', 'Administrator'),
(2, 'RIKI', 'dc131ed8751b5ac500a79b1d7207929c', 'Operator'),
(4, 'MARTONO', 'af7936442257f4a1b39e5f7f1c4e2c1c', 'Operator'),
(5, 'HENDRI', 'ee7e5d37b0b10c30a11df69c4e3d1d57', 'Operator');

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
  ADD PRIMARY KEY (`IdKendaraan`),
  ADD UNIQUE KEY `Plat` (`Plat`);

--
-- Indexes for table `tbmpartai`
--
ALTER TABLE `tbmpartai`
  ADD PRIMARY KEY (`IdPartai`);

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
  MODIFY `IdBarang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `tbmgudang`
--
ALTER TABLE `tbmgudang`
  MODIFY `IdGudang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbmkaryawan`
--
ALTER TABLE `tbmkaryawan`
  MODIFY `IdKaryawan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `tbmkendaraan`
--
ALTER TABLE `tbmkendaraan`
  MODIFY `IdKendaraan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `tbmpartai`
--
ALTER TABLE `tbmpartai`
  MODIFY `IdPartai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbmpemasok`
--
ALTER TABLE `tbmpemasok`
  MODIFY `IdPemasok` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbmpeminta`
--
ALTER TABLE `tbmpeminta`
  MODIFY `IdPeminta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbmpenerima`
--
ALTER TABLE `tbmpenerima`
  MODIFY `IdPenerima` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbmutasi`
--
ALTER TABLE `tbmutasi`
  MODIFY `IdMutasi` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbpacking`
--
ALTER TABLE `tbpacking`
  MODIFY `IdPacking` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbpenerimaan`
--
ALTER TABLE `tbpenerimaan`
  MODIFY `IdPenerimaan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=82;

--
-- AUTO_INCREMENT for table `tbpenjualan`
--
ALTER TABLE `tbpenjualan`
  MODIFY `IdPenjualan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbpenjualandetail`
--
ALTER TABLE `tbpenjualandetail`
  MODIFY `IdPenjualanDetail` int(11) NOT NULL AUTO_INCREMENT;

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
  MODIFY `IdUser` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
