-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: mysql-projetsep.alwaysdata.net
-- Generation Time: Jan 12, 2021 at 02:51 PM
-- Server version: 10.5.5-MariaDB
-- PHP Version: 7.2.29

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projetsep_werewolves`
--
CREATE DATABASE IF NOT EXISTS `projetsep_werewolves` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `projetsep_werewolves`;

-- --------------------------------------------------------

--
-- Table structure for table `FriendRequest`
--

DROP TABLE IF EXISTS `FriendRequest`;
CREATE TABLE `FriendRequest` (
  `requesterId` int(8) NOT NULL,
  `invitedId` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `FriendRequest`
--

INSERT INTO `FriendRequest` (`requesterId`, `invitedId`) VALUES
(9, 11),
(11, 8);

-- --------------------------------------------------------

--
-- Table structure for table `Friends`
--

DROP TABLE IF EXISTS `Friends`;
CREATE TABLE `Friends` (
  `id1` int(8) NOT NULL,
  `id2` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Friends`
--

INSERT INTO `Friends` (`id1`, `id2`) VALUES
(8, 9),
(11, 34),
(11, 38);

-- --------------------------------------------------------

--
-- Table structure for table `Game`
--

DROP TABLE IF EXISTS `Game`;
CREATE TABLE `Game` (
  `gameId` int(11) NOT NULL,
  `numberOfPlayers` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `numberOfWerewolves` int(11) NOT NULL,
  `hasWitch` tinyint(1) NOT NULL,
  `hasLittleGirl` tinyint(1) NOT NULL,
  `hasCupid` tinyint(1) NOT NULL,
  `hasHunter` tinyint(1) NOT NULL,
  `hasFortuneTeller` tinyint(1) NOT NULL,
  `finish` tinyint(1) NOT NULL,
  `currentPhase` varchar(6) NOT NULL,
  `availableGame` tinyint(1) NOT NULL,
  `creatorUsername` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Game`
--

INSERT INTO `Game` (`gameId`, `numberOfPlayers`, `status`, `numberOfWerewolves`, `hasWitch`, `hasLittleGirl`, `hasCupid`, `hasHunter`, `hasFortuneTeller`, `finish`, `currentPhase`, `availableGame`, `creatorUsername`) VALUES
(1, 8, 0, 1, 0, 0, 0, 0, 0, 0, 'SET UP', 0, 'test'),
(166, 8, 0, 1, 0, 0, 0, 0, 0, 0, 'SET UP', 0, 'test'),
(186, 2, 1, 1, 0, 0, 0, 0, 0, 0, 'NIGHT', 0, 'testttt'),
(198, 2, 1, 1, 0, 0, 0, 0, 0, 0, 'NIGHT', 0, 'testttt'),
(236, 2, 1, 1, 0, 0, 1, 0, 0, 0, 'NIGHT', 0, 'usernameTest');

-- --------------------------------------------------------

--
-- Table structure for table `GameRequest`
--

DROP TABLE IF EXISTS `GameRequest`;
CREATE TABLE `GameRequest` (
  `gamId` int(11) NOT NULL,
  `requesterUsername` varchar(50) NOT NULL,
  `invitedUsername` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `Player`
--

DROP TABLE IF EXISTS `Player`;
CREATE TABLE `Player` (
  `userId` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `gender` varchar(6) NOT NULL,
  `country` varchar(50) NOT NULL,
  `playedGames` int(11) NOT NULL,
  `wonGames` int(11) NOT NULL,
  `lostGames` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Player`
--

INSERT INTO `Player` (`userId`, `username`, `dateOfBirth`, `gender`, `country`, `playedGames`, `wonGames`, `lostGames`, `status`) VALUES
(8, 'hinna', '1998-10-27', 'Female', 'France', 5, 3, 2, 1),
(9, 'iFrag', '1998-12-09', 'Male', 'France', 5, 2, 3, 1),
(11, 'usernameTest', '1998-12-21', 'Male', 'USA', 3, 2, 1, 0),
(34, 'test', '2020-12-08', 'Male', 'USA', 0, 0, 0, 1),
(35, 'testttt', '2020-12-08', 'Female', 'USA', 0, 0, 0, 1),
(36, 'kijhgbvfcd', '2020-12-17', 'Female', 'England', 0, 0, 0, 1),
(37, 'lkjhgf', '2020-01-06', 'Male', 'France', 0, 0, 0, 1),
(38, 'mona', '2020-12-06', 'Male', 'England', 0, 0, 0, 1),
(39, 'username2', '2014-12-07', 'Female', 'England', 0, 0, 0, 1),
(40, 'username3', '2007-12-03', 'Male', 'USA', 0, 0, 0, 1),
(41, 'username4', '1997-12-25', 'Female', 'France', 0, 0, 0, 1),
(42, 'clare98', '2021-01-03', 'Female', 'France', 0, 0, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `PlayerInGame`
--

DROP TABLE IF EXISTS `PlayerInGame`;
CREATE TABLE `PlayerInGame` (
  `gameId` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `creator` tinyint(1) NOT NULL,
  `proposeAsASheriff` tinyint(1) NOT NULL,
  `isAlive` tinyint(1) NOT NULL,
  `role` varchar(50) NOT NULL,
  `isSheriff` tinyint(1) NOT NULL,
  `inLove` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `PlayerInGame`
--

INSERT INTO `PlayerInGame` (`gameId`, `username`, `creator`, `proposeAsASheriff`, `isAlive`, `role`, `isSheriff`, `inLove`) VALUES
(186, 'test', 0, 0, 1, 'Werewolf', 0, 0),
(186, 'testttt', 1, 0, 1, 'Villager', 0, 0),
(198, 'test', 0, 0, 1, 'Werewolf', 0, 0),
(198, 'testttt', 1, 0, 1, 'Villager', 0, 0),
(236, 'test', 0, 1, 1, 'Cupid', 0, 1),
(236, 'usernameTest', 1, 1, 1, 'Werewolf', 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `Report`
--

DROP TABLE IF EXISTS `Report`;
CREATE TABLE `Report` (
  `reportId` int(11) NOT NULL,
  `subject` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `isBugReport` tinyint(1) NOT NULL,
  `attachementLink` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Report`
--

INSERT INTO `Report` (`reportId`, `subject`, `description`, `isBugReport`, `attachementLink`) VALUES
(1, 'DISOBEYING RULES', 'The player crouvel says his role during the game... it\'s a typical case of disobeying rules...', 0, ''),
(2, 'Display password', 'I don\'t know why my password is not the same in my profile... Can you correct them ?I don\'t know why my password is not the same in my profile... Can you correct them ?I don\'t know why my password is not the same in my profile... Can you correct them ?I don\'t know why my password is not the same in my profile... Can you correct them ?I don\'t know why my password is not the same in my profile... Can you correct them ?I don\'t know why my password is not the same in my profile... Can you correct them ?I don\'t know why my password is not the same in my profile... Can you correct them ?I don\'t know why my password is not the same in my profile... Can you correct them ?I don\'t know why my password is not the same in my profile... Can you correct them ?', 1, 'https://i.imgur.com/mjfr7Co.png'),
(3, 'test', 'test', 1, 'https://i.imgur.com/mjfr7Co.png'),
(5, 'test2', 'test', 1, 'https://phpmyadmin.alwaysdata.com/phpmyadmin/sql.php?db=projetsep_werewolves&table=Report&token=8cd4f90171c4e1cac2e99a012fd296bd&pos=0'),
(6, 'test3', 'test', 1, 'https://i.imgur.com/mjfr7Co.png'),
(7, 'test4', 'test', 1, 'https://i.imgur.com/mjfr7Co.png'),
(8, 'DISOBEYING RULES', 'Reported Player: test\r\n\r\nDescrption: jhhjhjghjh', 1, ''),
(9, 'DISOBEYING RULES', 'Reported Player: test\n\n', 1, ''),
(10, 'DISOBEYING RULES', 'Reported Player: testttt\n\n', 1, ''),
(11, 'DISOBEYING RULES', 'Reported Player: testttt\n\n', 1, ''),
(12, 'INAPPROPRIATE BEHAVIOR', 'Reported Player: test\n\ncggvjgjhhjhj', 1, ''),
(14, 'gree', 'lalala', 1, 'https://d1fmx1rbmqrxrr.cloudfront.net/cnet/optim/i/edit/2019/04/eso1644bsmall__w770.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `userId` int(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(256) NOT NULL,
  `isAdmin` tinyint(1) NOT NULL,
  `isLockedAccount` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`userId`, `email`, `password`, `isAdmin`, `isLockedAccount`) VALUES
(8, 'tiffany.dumaire@etu.umontpellier.fr', 'b04933ad87779b1ba493b0a3b017656cef45e11e984679cd55dbeeb75bf1dff3', 1, 0),
(9, 'aaron.lazaroo@etu.umontpellier.fr', 'b04933ad87779b1ba493b0a3b017656cef45e11e984679cd55dbeeb75bf1dff3', 0, 0),
(10, 'admin@admin.fr', '45b72f147be46d52cd8a793ea67f31b64d940ccad87c2befa670d1851069bdf8', 1, 0),
(11, 'user@user.com', 'b04933ad87779b1ba493b0a3b017656cef45e11e984679cd55dbeeb75bf1dff3', 0, 0),
(15, 'admin2@admin.fr', 'b04933ad87779b1ba493b0a3b017656cef45e11e984679cd55dbeeb75bf1dff3', 1, 0),
(16, 'clarence', 'b04933ad87779b1ba493b0a3b017656cef45e11e984679cd55dbeeb75bf1dff3', 1, 0),
(34, 'test@test.fr', '45b72f147be46d52cd8a793ea67f31b64d940ccad87c2befa670d1851069bdf8', 0, 0),
(35, 'fff@gggl.fr', '45b72f147be46d52cd8a793ea67f31b64d940ccad87c2befa670d1851069bdf8', 0, 0),
(36, 'ffggg@fgfgf.com', 'fcebf11bae73005a492c1e6373c6664bccfe0979fa5ef52815f301c869bdeb99', 0, 0),
(37, 'loli@loli.com', '091c9b64deb993818148cda13d8ba990be92e0f358ebc3087a8f05d86d045380', 0, 0),
(38, 'mona@gmail.com', '7a83e2a3d0d0bbb1db1e9cd6459471aa1dd45c75699352e791cf7868bb585e2f', 0, 0),
(39, 'username2@gmail.com', 'a51bc0dcf16a706c759b6cf85530c523048299655b509947d65979adc9e20c57', 0, 0),
(40, 'username3@gmail.com', 'a51bc0dcf16a706c759b6cf85530c523048299655b509947d65979adc9e20c57', 0, 0),
(41, 'username4@gmail.com', '6d1ab98ed8849eed40026b9b7977ea9570c16f07acd4124a476843a8db61b27d', 0, 0),
(42, 'clarence@clarence.com', '3a3468fa89b2ab7cbfe5400858a8ec0066e9e8defa9a64c993b5f24210244df8', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `Vote`
--

DROP TABLE IF EXISTS `Vote`;
CREATE TABLE `Vote` (
  `gameId` int(11) NOT NULL,
  `voterUsername` varchar(50) NOT NULL,
  `votedUsername` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `FriendRequest`
--
ALTER TABLE `FriendRequest`
  ADD PRIMARY KEY (`requesterId`,`invitedId`),
  ADD KEY `InvitedKey` (`invitedId`);

--
-- Indexes for table `Friends`
--
ALTER TABLE `Friends`
  ADD PRIMARY KEY (`id1`,`id2`),
  ADD KEY `ID2KEY` (`id2`);

--
-- Indexes for table `Game`
--
ALTER TABLE `Game`
  ADD PRIMARY KEY (`gameId`),
  ADD KEY `creatorUsername` (`creatorUsername`);

--
-- Indexes for table `GameRequest`
--
ALTER TABLE `GameRequest`
  ADD PRIMARY KEY (`gamId`,`requesterUsername`,`invitedUsername`),
  ADD KEY `usernameRequester` (`requesterUsername`),
  ADD KEY `usernameInvited` (`invitedUsername`);

--
-- Indexes for table `Player`
--
ALTER TABLE `Player`
  ADD PRIMARY KEY (`userId`,`username`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `PlayerInGame`
--
ALTER TABLE `PlayerInGame`
  ADD PRIMARY KEY (`gameId`,`username`),
  ADD KEY `usernameKey` (`username`);

--
-- Indexes for table `Report`
--
ALTER TABLE `Report`
  ADD PRIMARY KEY (`reportId`);

--
-- Indexes for table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`userId`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `Vote`
--
ALTER TABLE `Vote`
  ADD PRIMARY KEY (`gameId`,`voterUsername`,`votedUsername`),
  ADD KEY `VoterUsernameFK` (`voterUsername`),
  ADD KEY `VotedUsernameFK` (`votedUsername`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Game`
--
ALTER TABLE `Game`
  MODIFY `gameId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=241;

--
-- AUTO_INCREMENT for table `Report`
--
ALTER TABLE `Report`
  MODIFY `reportId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `User`
--
ALTER TABLE `User`
  MODIFY `userId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `FriendRequest`
--
ALTER TABLE `FriendRequest`
  ADD CONSTRAINT `InvitedKey` FOREIGN KEY (`invitedId`) REFERENCES `Player` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `RequesterKey` FOREIGN KEY (`requesterId`) REFERENCES `Player` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Friends`
--
ALTER TABLE `Friends`
  ADD CONSTRAINT `ID1KEY` FOREIGN KEY (`id1`) REFERENCES `Player` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ID2KEY` FOREIGN KEY (`id2`) REFERENCES `Player` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `GameRequest`
--
ALTER TABLE `GameRequest`
  ADD CONSTRAINT `gameIDKey` FOREIGN KEY (`gamId`) REFERENCES `Game` (`gameId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `usernameInvited` FOREIGN KEY (`invitedUsername`) REFERENCES `Player` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `usernameRequester` FOREIGN KEY (`requesterUsername`) REFERENCES `Player` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Player`
--
ALTER TABLE `Player`
  ADD CONSTRAINT `USERIDKEY` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `PlayerInGame`
--
ALTER TABLE `PlayerInGame`
  ADD CONSTRAINT `gameIDPlayerKey` FOREIGN KEY (`gameId`) REFERENCES `Game` (`gameId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `usernameKey` FOREIGN KEY (`username`) REFERENCES `Player` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Vote`
--
ALTER TABLE `Vote`
  ADD CONSTRAINT `VotedUsernameFK` FOREIGN KEY (`votedUsername`) REFERENCES `PlayerInGame` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `VoterUsernameFK` FOREIGN KEY (`voterUsername`) REFERENCES `PlayerInGame` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `gameIdVoteKey` FOREIGN KEY (`gameId`) REFERENCES `Game` (`gameId`) ON DELETE CASCADE ON UPDATE CASCADE;


--
-- Metadata
--
USE `ad-phpmyadmin_configuration`;

--
-- Metadata for table FriendRequest
--
-- Error reading data for table ad-phpmyadmin_configuration.pma__column_info: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__column_info'
-- Error reading data for table ad-phpmyadmin_configuration.pma__table_uiprefs: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__table_uiprefs'
-- Error reading data for table ad-phpmyadmin_configuration.pma__tracking: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__tracking'

--
-- Metadata for table Friends
--
-- Error reading data for table ad-phpmyadmin_configuration.pma__column_info: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__column_info'
-- Error reading data for table ad-phpmyadmin_configuration.pma__table_uiprefs: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__table_uiprefs'
-- Error reading data for table ad-phpmyadmin_configuration.pma__tracking: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__tracking'

--
-- Metadata for table Game
--
-- Error reading data for table ad-phpmyadmin_configuration.pma__column_info: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__column_info'
-- Error reading data for table ad-phpmyadmin_configuration.pma__table_uiprefs: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__table_uiprefs'
-- Error reading data for table ad-phpmyadmin_configuration.pma__tracking: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__tracking'

--
-- Metadata for table GameRequest
--
-- Error reading data for table ad-phpmyadmin_configuration.pma__column_info: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__column_info'
-- Error reading data for table ad-phpmyadmin_configuration.pma__table_uiprefs: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__table_uiprefs'
-- Error reading data for table ad-phpmyadmin_configuration.pma__tracking: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__tracking'

--
-- Metadata for table Player
--
-- Error reading data for table ad-phpmyadmin_configuration.pma__column_info: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__column_info'
-- Error reading data for table ad-phpmyadmin_configuration.pma__table_uiprefs: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__table_uiprefs'
-- Error reading data for table ad-phpmyadmin_configuration.pma__tracking: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__tracking'

--
-- Metadata for table PlayerInGame
--
-- Error reading data for table ad-phpmyadmin_configuration.pma__column_info: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__column_info'
-- Error reading data for table ad-phpmyadmin_configuration.pma__table_uiprefs: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__table_uiprefs'
-- Error reading data for table ad-phpmyadmin_configuration.pma__tracking: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__tracking'

--
-- Metadata for table Report
--
-- Error reading data for table ad-phpmyadmin_configuration.pma__column_info: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__column_info'
-- Error reading data for table ad-phpmyadmin_configuration.pma__table_uiprefs: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__table_uiprefs'
-- Error reading data for table ad-phpmyadmin_configuration.pma__tracking: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__tracking'

--
-- Metadata for table User
--
-- Error reading data for table ad-phpmyadmin_configuration.pma__column_info: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__column_info'
-- Error reading data for table ad-phpmyadmin_configuration.pma__table_uiprefs: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__table_uiprefs'
-- Error reading data for table ad-phpmyadmin_configuration.pma__tracking: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__tracking'

--
-- Metadata for table Vote
--
-- Error reading data for table ad-phpmyadmin_configuration.pma__column_info: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__column_info'
-- Error reading data for table ad-phpmyadmin_configuration.pma__table_uiprefs: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__table_uiprefs'
-- Error reading data for table ad-phpmyadmin_configuration.pma__tracking: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__tracking'

--
-- Metadata for database projetsep_werewolves
--
-- Error reading data for table ad-phpmyadmin_configuration.pma__bookmark: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__bookmark'
-- Error reading data for table ad-phpmyadmin_configuration.pma__relation: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__relation'
-- Error reading data for table ad-phpmyadmin_configuration.pma__savedsearches: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__savedsearches'
-- Error reading data for table ad-phpmyadmin_configuration.pma__central_columns: #1142 - SELECT command denied to user 'projetsep'@'2a00:b6e0:1:210:1::1' for table 'pma__central_columns'
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
