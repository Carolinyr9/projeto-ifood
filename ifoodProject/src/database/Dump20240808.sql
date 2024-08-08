-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: bdelivery
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cardapio`
--

DROP TABLE IF EXISTS `cardapio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cardapio` (
  `id` int NOT NULL,
  `id_restaurante` int NOT NULL,
  `id_prato` int DEFAULT NULL,
  `id_produto` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cardapio`
--

LOCK TABLES `cardapio` WRITE;
/*!40000 ALTER TABLE `cardapio` DISABLE KEYS */;
INSERT INTO `cardapio` VALUES (3703,1,0,0),(7498,1,0,0),(885,1,0,0),(7912,1,0,NULL),(2979,1,1946,NULL),(5134,1,3857,NULL),(8061,1,NULL,9081);
/*!40000 ALTER TABLE `cardapio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrinho`
--

DROP TABLE IF EXISTS `carrinho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrinho` (
  `id` int NOT NULL,
  `id_prato` int DEFAULT NULL,
  `id_produto` int DEFAULT NULL,
  `id_restaurante` int NOT NULL,
  `preco` decimal(10,2) NOT NULL,
  `endereco_entrega` varchar(255) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `quantidade` int NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrinho`
--

LOCK TABLES `carrinho` WRITE;
/*!40000 ALTER TABLE `carrinho` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrinho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `id` int NOT NULL,
  `status` enum('pendente','em preparo','em entrega','entregue','cancelado') CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `id_carrinho` int NOT NULL,
  `id_cliente` int NOT NULL,
  `id_entregador` int DEFAULT NULL,
  `data_pedido` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_atualizacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prato`
--

DROP TABLE IF EXISTS `prato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prato` (
  `id` int NOT NULL,
  `nome` varchar(100) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `descricao` text CHARACTER SET utf16 COLLATE utf16_bin,
  `ingredientes` text CHARACTER SET utf16 COLLATE utf16_bin,
  `preco` decimal(10,2) NOT NULL,
  `id_restaurante` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prato`
--

LOCK TABLES `prato` WRITE;
/*!40000 ALTER TABLE `prato` DISABLE KEYS */;
INSERT INTO `prato` VALUES (1,'aaaaaaaa','aaaaaaaaaaa','aaaaaaaa',3.00,1),(1,'aaaaaaaa','aaaaaaaaaaa','aaaaaaaa',3.00,1),(9223,'teste','ffffffffffff','aaaaaaaaaa',5.00,1),(5014,'aaaaaaaaa','fffff','fffff',5.00,1),(1059,'yyyyyyyy','gggggg','ttttttt',5.00,1),(1946,'aaabcs','fffffffff','fffffffff',5.00,1),(3857,'aaabcs','fffffffff','fffffffff',5.00,1);
/*!40000 ALTER TABLE `prato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `id` int NOT NULL,
  `nome` varchar(100) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `descricao` text CHARACTER SET utf16 COLLATE utf16_bin,
  `preco` decimal(10,2) NOT NULL,
  `id_restaurante` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'aaaaaa','ffffffff',2.00,1),(1,'aaaaaaa','fffffffff',5.00,1),(1,'aaaaa','aaaaaaaa',6.00,1),(9081,'ggggggg','ffffffff',67.00,1);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurante`
--

DROP TABLE IF EXISTS `restaurante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurante` (
  `id` int NOT NULL,
  `nome` varchar(100) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `cnpj` varchar(14) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `cep` varchar(8) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `rua` varchar(250) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `cidade` varchar(100) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `estado` varchar(2) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `numero_residencial` varchar(10) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `telefone` varchar(15) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `segmento` varchar(100) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurante`
--

LOCK TABLES `restaurante` WRITE;
/*!40000 ALTER TABLE `restaurante` DISABLE KEYS */;
/*!40000 ALTER TABLE `restaurante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL,
  `nome` varchar(100) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `data_nascimento` date NOT NULL,
  `telefone` varchar(15) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `rua` varchar(255) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `cidade` varchar(100) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `estado` varchar(2) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `cep` varchar(8) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `numero_residencial` varchar(10) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `cpf` varchar(11) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `cnh` varchar(11) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `codigo_funcional` varchar(20) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `email` varchar(100) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `senha` varchar(255) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `tipo` enum('administrador','cliente','entregador','funcionario') CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `id_restaurante` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-08 18:50:44
