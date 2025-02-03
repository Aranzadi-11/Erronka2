-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-02-2025 a las 12:55:43
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `erronka2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `erabiltzaileak`
--

CREATE TABLE `erabiltzaileak` (
  `ID` int(11) NOT NULL,
  `Izena` varchar(100) NOT NULL,
  `Abizena` varchar(100) NOT NULL,
  `Erabiltzailea` varchar(100) NOT NULL,
  `Pasahitza` varchar(255) NOT NULL,
  `Jaiotze_Eguna` date NOT NULL,
  `Helbidea` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `erabiltzaileak`
--

INSERT INTO `erabiltzaileak` (`ID`, `Izena`, `Abizena`, `Erabiltzailea`, `Pasahitza`, `Jaiotze_Eguna`, `Helbidea`) VALUES
(1, 'Aitor', 'Etxebarria', 'aitor.etx', 'Ait1234!etx', '1990-02-15', 'Txoko 5, 20010 Donostia'),
(2, 'Maite', 'Zubizarreta', 'maite.zubi', 'Mai1234!zubi', '1985-08-22', 'Kale Nagusia 21, 48012 Bilbo'),
(3, 'Jon', 'Goikoetxea', 'jon.goik', 'Jon1234!goik', '1992-03-30', 'Oinez 3, 31001 Iruñea'),
(4, 'Ane', 'Ibarrola', 'ane.ibar', 'Ane1234!ibar', '1994-05-10', 'Erreka 12, 48100 Mungia'),
(5, 'Iker', 'Lizeaga', 'iker.lize', 'Ike1234!lize', '1991-01-03', 'Zuloa 9, 20500 Arrasate'),
(6, 'Mikel', 'Olabarria', 'mikel.ola', 'Mik1234!ola', '1987-07-15', 'Urgoiti 18, 20280 Hondarribia'),
(7, 'Nahia', 'Zugasti', 'nahia.zuga', 'Nah1234!zuga', '1993-12-05', 'Auzo Nagusia 25, 20012 Donostia'),
(8, 'Eneko', 'Bergara', 'eneko.berg', 'Enk1234!berg', '1989-06-18', 'Lehen Kalea 3, 48200 Durango'),
(9, 'Leire', 'Arrizabalaga', 'leire.arr', 'Lei1234!arr', '1990-11-02', 'Baserria 14, 48150 Erandio'),
(10, 'Unai', 'Egurrola', 'unai.egur', 'Una1234!egur', '1992-09-12', 'Goiko 5, 48950 Zaratamo'),
(11, 'Oier', 'Aranguren', 'oier.ara', 'Oie1234!ara', '1991-04-20', 'Kalea 7, 20080 Donostia'),
(12, 'June', 'Urresti', 'june.urr', 'Jun1234!urr', '1994-01-30', 'Galtzada 11, 48005 Bilbo'),
(13, 'Ander', 'Beitia', 'ander.bei', 'And1234!bei', '1988-02-10', 'Zuloa 2, 20250 Lasarte-Oria'),
(14, 'Haizea', 'Lertxundi', 'haizea.ler', 'Hai1234!ler', '1993-10-01', 'Bide Zaharra 6, 48180 Loiu'),
(15, 'Xabier', 'Aristi', 'xabier.ari', 'Xab1234!ari', '1991-07-14', 'Ibarrondo 22, 20260 Lasarte-Oria'),
(16, 'Irati', 'Laskurain', 'irati.las', 'Ira1234!las', '1992-03-25', 'Aldapa 17, 48920 Portugalete'),
(17, 'Markel', 'Garmendia', 'markel.gar', 'Mar1234!gar', '1990-09-10', 'Arriaga 4, 20305 Errenteria'),
(18, 'Izaro', 'Urrutia', 'izaro.urr', 'Iza1234!urr', '1991-11-22', 'Mendieta 3, 48130 Gernika'),
(19, 'Julen', 'Altuna', 'julen.alt', 'Jul1234!alt', '1994-08-15', 'Kale Nagusia 5, 20060 Donostia'),
(20, 'Oihana', 'Etxaniz', 'oihana.etx', 'Oih1234!etx', '1989-05-17', 'Olano 12, 48980 Barakaldo'),
(21, 'Ekain', 'Zaldua', 'ekain.zal', 'Eka1234!zal', '1993-01-11', 'Zuloa 8, 20800 Zarautz'),
(22, 'Uxue', 'Legarreta', 'uxue.leg', 'Uxue1234!leg', '1990-10-25', 'Baserri 4, 48100 Mungia'),
(23, 'Beñat', 'Lizarralde', 'benat.liz', 'Ben1234!liz', '1992-06-12', 'Kale Erreka 3, 20800 Zarautz'),
(24, 'Ane', 'Mendizabal', 'ane.men', 'Ane1234!men', '1988-02-28', 'Eguzki 13, 20012 Donostia'),
(25, 'Gorka', 'Otegi', 'gorka.ote', 'Gor1234!ote', '1994-11-09', 'Mendibeltz 6, 48970 Basauri'),
(26, 'Maialen', 'Errasti', 'maialen.err', 'Mai1234!err', '1991-03-18', 'Behekoa 15, 20800 Zarautz'),
(27, 'Eñaut', 'Sagastizabal', 'enaut.sag', 'Enau1234!sag', '1992-07-21', 'Laubide 7, 20200 Beasain'),
(28, 'Nerea', 'Aldazabal', 'nerea.ald', 'Ner1234!ald', '1993-09-14', 'Sarrikobaso 9, 48100 Bilbo'),
(29, 'Xabi', 'Zabala', 'xabi.zab', 'Xab1234!zab', '1989-04-28', 'Txirriskitxu 8, 20250 Lasarte-Oria'),
(30, 'Amaia', 'Erostarbe', 'amaia.ero', 'Ama1234!ero', '1991-12-30', 'Aldabide 14, 48200 Durango');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eskaerak`
--

CREATE TABLE `eskaerak` (
  `ID` int(11) NOT NULL,
  `ID_Erabiltzailea` int(11) NOT NULL,
  `ID_Produktua` int(11) NOT NULL,
  `Eskaera_Data` date NOT NULL DEFAULT curdate(),
  `Kantitatea` int(11) NOT NULL,
  `Prezioa` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hornitzaileak`
--

CREATE TABLE `hornitzaileak` (
  `ID` int(11) NOT NULL,
  `Enpresa_Izena` varchar(75) NOT NULL,
  `Produktua` varchar(100) NOT NULL,
  `Produktuaren_Deskripzioa` varchar(255) DEFAULT NULL,
  `Dohaintzaren_Eguna` date NOT NULL DEFAULT curdate()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `hornitzaileak`
--

INSERT INTO `hornitzaileak` (`ID`, `Enpresa_Izena`, `Produktua`, `Produktuaren_Deskripzioa`, `Dohaintzaren_Eguna`) VALUES
(1, 'Indra', 'Software kudeaketa', 'Enpresen kudeaketa eta automatizazio softwareak.', '2025-02-03'),
(2, 'Everis', 'Digitalizazio soluzioak', 'Enpresen digitalizazio eta transformatu teknologikoak.', '2025-02-03'),
(3, 'Sopra Steria', 'IT zerbitzuak', 'Enpresen IT azpiegiturak eta software soluzioak.', '2025-02-03'),
(4, 'Accenture', 'Aplikazio garapena', 'Aplikazioak eta soluzio digitalak enpresa guztientzat.', '2025-02-03'),
(5, 'Altran', 'Ingeniaritza eta software garapena', 'Ingeniaritza aurreratua eta software garapena.', '2025-02-03'),
(6, 'Atos', 'Zero trust segurtasuna', 'Segurtasun soluzioak enpresen sareetan.', '2025-02-03'),
(7, 'DXC Technology', 'Kudeaketa softwarea', 'Enpresen prozesuen kudeaketa eta optimizazio softwarea.', '2025-02-03'),
(8, 'IBM', 'Cloud computing', 'Cloud computing eta sistema integratzaileak.', '2025-02-03'),
(9, 'T-Systems', 'Aplikazioen garapena', 'Aplikazioen kudeaketa eta garapena enpresa handientzat.', '2025-02-03'),
(10, 'Capgemini', 'Cloud zerbitzuak', 'Cloud platformak eta enpresa digitalizazioa.', '2025-02-03'),
(11, 'Minsait', 'Smart solutions', 'Enpresen smart solutions eta transformazio digitala.', '2025-02-03'),
(12, 'Tecnalia', 'Ikerketa teknologikoa', 'Enpresa teknologikoen ikerketa eta berrikuntza proiektuak.', '2025-02-03'),
(13, 'Grupo SIA', 'Segurtasun softwarea', 'Sistemen segurtasuna eta datuen babeserako soluzioak.', '2025-02-03'),
(14, 'Zemax', 'Simulazio optiko softwarea', 'Optika alorreko simulazio software aurreratuak.', '2025-02-03'),
(15, 'Mantenimiento Informático Gipuzkoa', 'Informazioaren kudeaketa', 'Informatika mantentze eta kudeaketa zerbitzuak.', '2025-02-03'),
(16, 'Gfi España', 'Softwareen garapena', 'Software garapena eta proiektuen kudeaketa.', '2025-02-03'),
(17, 'Unify', 'Komunikazio soluzioak', 'Enpresen komunikazio soluzioak eta sistema integratuak.', '2025-02-03'),
(18, 'Hewlett Packard', 'Informatika ekipamenduak', 'Informatika ekipamendu eta IT azpiegiturak.', '2025-02-03'),
(19, 'Sage', 'Finantza kudeaketa softwarea', 'Finantza eta enpresa kudeaketarako softwarea.', '2025-02-03'),
(20, 'SAP', 'ERP softwarea', 'Enpresen ERP soluzioak eta datu kudeaketa softwarea.', '2025-02-03'),
(21, 'Kyndryl', 'Infrastruktura kudeaketa', 'Enpresen IT azpiegituren kudeaketa eta zerbitzuak.', '2025-02-03'),
(22, 'Broadcom', 'Semiconductoreak', 'Prozesadore eta sistema integratuak.', '2025-02-03'),
(23, 'Oracle', 'Datubase kudeaketa', 'Datubase kudeaketa eta informazioaren kudeaketa soluzioak.', '2025-02-03'),
(24, 'Huawei', 'Telekomunikazio soluzioak', 'Telekomunikazioen eta cloud computing soluzioak.', '2025-02-03'),
(25, 'Microsoft', 'Software produktibitatea', 'Ofimatikarako softwarea eta produktibitate tresnak.', '2025-02-03'),
(26, 'Google', 'Cloud zerbitzuak', 'Google Cloud zerbitzuak eta aplikazioen garapena.', '2025-02-03'),
(27, 'Amazon Web Services', 'Cloud soluzioak', 'Enpresen cloud zerbitzuak eta azpiegiturak.', '2025-02-03'),
(28, 'Dell Technologies', 'Informatika hardwarea', 'Informatika ekipamenduak eta datu zentroen soluzioak.', '2025-02-03'),
(29, 'Nokia', 'Telekomunikazio ekipamenduak', 'Telekomunikazioen azpiegitura eta ekipamenduak.', '2025-02-03'),
(30, 'LG Electronics', 'Elektronika eta informatika hardwarea', 'Informatika hardwarea eta multimedia ekipoak.', '2025-02-03');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `langileak`
--

CREATE TABLE `langileak` (
  `ID` int(11) NOT NULL,
  `Izena` varchar(50) NOT NULL,
  `Abizena` varchar(50) NOT NULL,
  `Erabiltzailea` varchar(6) GENERATED ALWAYS AS (concat(left(`Izena`,4),left(`Abizena`,1))) STORED,
  `Pasahitza` varchar(50) GENERATED ALWAYS AS (concat(ucase(left(`Izena`,1)),lcase(left(`Abizena`,3)),'123')) STORED,
  `Langile_Mota` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `langileak`
--

INSERT INTO `langileak` (`ID`, `Izena`, `Abizena`, `Langile_Mota`) VALUES
(1, 'Aitor', 'Etxebarria', 'Administratzailea'),
(2, 'Maite', 'Zubizarreta', 'Administratzailea'),
(3, 'Jon', 'Goikoetxea', 'Administratzailea'),
(4, 'Ane', 'Ibarrola', 'Administratzailea'),
(5, 'Iker', 'Lizeaga', 'Administratzailea'),
(6, 'Mikel', 'Olabarria', 'Programatzailea'),
(7, 'Nahia', 'Zugasti', 'Datu base gestorea'),
(8, 'Eneko', 'Bergara', 'Web garatzailea'),
(9, 'Leire', 'Arrizabalaga', 'Programatzailea'),
(10, 'Unai', 'Egurrola', 'Datu base gestorea'),
(11, 'Oier', 'Aranguren', 'Web garatzailea'),
(12, 'June', 'Urresti', 'Programatzailea'),
(13, 'Ander', 'Beitia', 'Datu base gestorea'),
(14, 'Haizea', 'Lertxundi', 'Web garatzailea'),
(15, 'Xabier', 'Aristi', 'Programatzailea'),
(16, 'Irati', 'Laskurain', 'Datu base gestorea'),
(17, 'Markel', 'Garmendia', 'Web garatzailea'),
(18, 'Izaro', 'Urrutia', 'Programatzailea'),
(19, 'Julen', 'Altuna', 'Datu base gestorea'),
(20, 'Oihana', 'Etxaniz', 'Web garatzailea'),
(21, 'Ekain', 'Zaldua', 'Programatzailea'),
(22, 'Uxue', 'Legarreta', 'Datu base gestorea'),
(23, 'Beñat', 'Lizarralde', 'Web garatzailea'),
(24, 'Ane', 'Mendizabal', 'Programatzailea'),
(25, 'Gorka', 'Otegi', 'Datu base gestorea'),
(26, 'Maialen', 'Errasti', 'Web garatzailea'),
(27, 'Eñaut', 'Sagastizabal', 'Programatzailea'),
(28, 'Nerea', 'Aldazabal', 'Datu base gestorea'),
(29, 'Xabi', 'Zabala', 'Web garatzailea'),
(30, 'Amaia', 'Erostarbe', 'Programatzailea');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stock`
--

CREATE TABLE `stock` (
  `ID` int(11) NOT NULL,
  `Izena` varchar(100) NOT NULL,
  `Deskripzioa` varchar(255) DEFAULT NULL,
  `Prezioa` double NOT NULL,
  `Kantitatea` int(11) NOT NULL,
  `Erositako_Eguna` date NOT NULL DEFAULT curdate(),
  `Argazkia_URL` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `stock`
--

INSERT INTO `stock` (`ID`, `Izena`, `Deskripzioa`, `Prezioa`, `Kantitatea`, `Erositako_Eguna`, `Argazkia_URL`) VALUES
(1, 'Ordenagailu portatila', 'Intel i7, 16GB RAM, 512GB SSD', 1200.99, 10, '2024-01-15', 'https://static.carrefour.es/hd_510x_/crs/cdn_static/catalog/hd/172217_00_1.jpg'),
(2, 'Telefono mugikorra', 'Android 12, 128GB, 6.5\" pantaila', 699.99, 25, '2024-01-10', 'https://m.media-amazon.com/images/I/613hqMuq6OL.jpg'),
(3, 'Teklatu mekanikoa', 'RGB, switch marroiak, USB-C', 89.5, 15, '2024-01-05', 'https://thumb.pccomponentes.com/w-530-530/articles/36/361718/3824-krom-kluster-teclado-mini-mecanico-rgb-usb-bluetooth-switch-outemu-red-mejor-precio.jpg'),
(4, 'Kable gabeko sagua', 'Bluetooth 5.0, DPI egokigarria', 45.99, 30, '2024-01-20', 'https://keychron.com.es/cdn/shop/files/Lemokey-G2-wireless-mouse-black.jpg?v=1724652780&width=1000'),
(5, '27\" monitorea', '144Hz, IPS, 1ms erantzuna', 299.99, 12, '2024-01-12', 'https://img.pccomponentes.com/articles/60/605420/1357-asus-tuf-gaming-vg28uql1a-28-led-ips-ultrahd-4k-144hz-g-sync-compatible.jpg'),
(6, 'Laser inprimagailua', 'Monokromo, WiFi, A4', 159.99, 8, '2024-01-18', 'https://img.pccomponentes.com/articles/1072/10722206/1385-pantum-cp1100dw-impresora-laser-color-wifi-duplex.jpg'),
(7, '1TB SSD disko gogorra', 'NVMe Gen4, 5000MB/s irakurketa', 129.99, 20, '2024-01-22', 'https://img.pccomponentes.com/articles/17/173199/sandisk-ssd-plus-120gb.jpg'),
(8, 'Txartel grafikoa', 'RTX 3070, 8GB GDDR6', 499.99, 5, '2024-01-07', 'https://img.pccomponentes.com/articles/52/528568/1116-gigabyte-geforce-rtx-3070-gaming-oc-lhr-v2-8gb-gddr6.jpg'),
(9, 'Bluetooth bozeragailua', 'Zarata ezeztatzea, 30h bateria', 79.99, 18, '2024-01-25', 'https://img.pccomponentes.com/articles/1064/10645328/123-bigben-party-s-altavoz-bluetooth-30w.jpg'),
(10, 'Kargadore azkarra', 'USB-C, 65W, Ordenagailuekin bateragarria', 34.99, 22, '2024-01-09', 'https://thumb.pccomponentes.com/w-530-530/articles/1075/10751607/3379-cool-cargador-universal-ultra-fast-pd-usb-c-usb-65w-cable-usb-c-gan-blanco-mejor-precio.jpg'),
(11, 'WiFi 6 errepikagailua', 'Bi banda, 1.8Gbps arte', 99.99, 14, '2024-01-14', 'https://img.pccomponentes.com/articles/78/781959/1997-cool-repetidor-wifi-universal-600mbps-high-range.jpg'),
(12, 'HD web kamera', '1080p, Mikrofono integratua', 49.99, 17, '2024-01-21', 'https://thumb.pccomponentes.com/w-530-530/articles/1086/10868131/1208-ngs-xpresscam-1080hd-webcam-para-pc-fullhd-1080p-usb-20-con-microfono-incorporado.jpg'),
(13, '10\" tableta', '4GB RAM, 64GB biltegiratzea', 219.99, 11, '2024-01-17', 'https://img.pccomponentes.com/articles/1081/10811536/1770-lenovo-tab-m11-11-4-128gb-gris-pen-stylus.jpg'),
(14, 'Espresso kafe-makina', '15 bar presioa, 1.5L depositua', 149.99, 9, '2024-01-06', 'https://thumb.pccomponentes.com/w-530-530/articles/23/237404/51vtu8dejtl-ac-sl1000.jpg'),
(15, 'Bozeragailu inteligentea', 'Ahots-kontrola, Bluetooth 5.1', 59.99, 20, '2024-01-11', 'https://img.pccomponentes.com/articles/24/243521/image-mini2-19-0403-0294-10-white-ttq-r04-simp.jpg'),
(16, 'Smartwatch', 'Loaren jarraipena, 14 eguneko bateria', 129.99, 13, '2024-01-19', 'https://img.pccomponentes.com/articles/1077/10776306/1979-cool-forest-smartwatch-silicona-gris.jpg'),
(17, 'LED lanpara', 'RGB, Urruneko kontrola, 10W', 24.99, 35, '2024-01-13', 'https://thumb.pccomponentes.com/w-530-530/articles/37/379063/1658-imperii-lampara-led-negra-con-cargador-qi.jpg'),
(18, 'USB mikrofonoa', 'Kondentsadorea, Estudio-kalitatea', 79.99, 16, '2024-01-08', 'https://img.pccomponentes.com/articles/32/327983/1303-blue-microphones-yeti-microfono-usb-negro-para-grabacion-y-transmision-en-pc-ff09943e-ed13-4890-a4a4-fbe3750fbef9.jpg'),
(19, '2TB kanpoko disko gogorra', 'USB 3.0, eramangarria', 99.99, 23, '2024-01-23', 'https://thumb.pccomponentes.com/w-530-530/articles/1063/10636817/1137-toshiba-canvio-partner-disco-duro-externo-25-1tb-usb-32.jpg'),
(20, 'Alarma erlojua', 'LED pantaila, Haririk gabeko karga', 39.99, 28, '2024-01-24', 'https://thumb.pccomponentes.com/w-530-530/articles/34/345451/125-spc-frodi-radio-despertador.jpg'),
(21, 'Ordenagailu sportea', 'Erregulagarria, Aluminioa', 29.99, 19, '2024-01-16', 'https://img.pccomponentes.com/articles/57/572181/1873-newstar-soporte-de-pared-para-mini-pc-vesa-100x100.jpg'),
(22, 'Motxila', 'USB integratua, Bizkarralde erosoa', 49.99, 21, '2024-01-26', 'https://thumb.pccomponentes.com/w-530-530/articles/1019/10190823/1149-subblim-secure-v2-ap-antitheft-backpack-mochila-antirrobo-negra-gris-para-portatiles-hasta-156.jpg'),
(23, '128GB USB memoria', 'USB 3.1, Abiadura handia', 29.99, 27, '2024-01-28', 'https://thumb.pccomponentes.com/w-530-530/articles/33/330597/1571-kingston-datatraveler-kyson-128gb-usb-32.jpg'),
(24, 'USB-C Hub', '4 ataka, HDMI, SD irakurgailua', 44.99, 24, '2024-01-29', 'https://thumb.pccomponentes.com/w-530-530/articles/1073/10735750/1899-conceptronic-hubbies13g-hub-usb-c-32-10gbps-2x-puertos-usb-c-2x-puertos-usb-a.jpg'),
(25, 'XXL mousepad', 'Oinarri irristagaitza, 90x40cm', 19.99, 40, '2024-01-30', 'https://thumb.pccomponentes.com/w-530-530/articles/38/386337/1738-trust-mouse-pad-xxl-alfombrilla-negra.jpg'),
(26, 'PC tresna-kit-a', 'Torlojugailuak, Pintzak, Xurgagailua', 39.99, 32, '2024-01-27', 'https://thumb.pccomponentes.com/w-530-530/articles/1084/10845051/1731-ifixit-eu145278-20-kit-de-herramientas-profesional-de-reparacion-de-dispositivos-electronicos.jpg'),
(27, 'Roomba', 'App bidez kontrola, Mapa adimenduna', 249.99, 6, '2024-01-31', 'https://img.pccomponentes.com/articles/36/363831/129-irobot-roomba-combo-robot-aspirador.jpg'),
(28, 'Segurtasun kamera', 'Gaueko ikusmena, Mugimendu detekzioa', 129.99, 10, '2024-02-01', 'https://thumb.pccomponentes.com/w-530-530/articles/1031/10312758/1509-tp-link-tc70-camara-de-vigilancia-wifi-360o-rotatoria-1080p.jpg'),
(29, 'Gaming aurikularrak', '7.1 Surround, Mikrofono desmuntagarria', 89.99, 12, '2024-02-02', 'https://img.pccomponentes.com/articles/43/433875/1729-forgeon-sergeant-auriculares-gaming-71-pc-ps4-ps5-xbox-xbox-x-switch-negros.jpg'),
(30, '32Gb USB memoria', 'USB 3.1, Abiadura handia', 19.99, 16, '2024-01-14', 'https://img.pccomponentes.com/articles/1042/10427984/117-cool-basic-32gb-usb-20-negro.jpg');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `erabiltzaileak`
--
ALTER TABLE `erabiltzaileak`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Erabiltzailea` (`Erabiltzailea`);

--
-- Indices de la tabla `eskaerak`
--
ALTER TABLE `eskaerak`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_Erabiltzailea` (`ID_Erabiltzailea`),
  ADD KEY `ID_Produktua` (`ID_Produktua`);

--
-- Indices de la tabla `hornitzaileak`
--
ALTER TABLE `hornitzaileak`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `langileak`
--
ALTER TABLE `langileak`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `erabiltzaileak`
--
ALTER TABLE `erabiltzaileak`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `eskaerak`
--
ALTER TABLE `eskaerak`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `hornitzaileak`
--
ALTER TABLE `hornitzaileak`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT de la tabla `langileak`
--
ALTER TABLE `langileak`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `stock`
--
ALTER TABLE `stock`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `eskaerak`
--
ALTER TABLE `eskaerak`
  ADD CONSTRAINT `eskaerak_ibfk_1` FOREIGN KEY (`ID_Erabiltzailea`) REFERENCES `erabiltzaileak` (`ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `eskaerak_ibfk_2` FOREIGN KEY (`ID_Produktua`) REFERENCES `stock` (`ID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
