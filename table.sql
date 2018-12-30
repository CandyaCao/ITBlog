CREATE TABLE `user` (

`id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,

`user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,

`user_gender` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,

`user_birthday` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,

PRIMARY KEY (`id`) 

)

ENGINE = InnoDB

AUTO_INCREMENT = 0

AVG_ROW_LENGTH = 0

DEFAULT CHARACTER SET = utf8mb4

COLLATE = utf8mb4_general_ci

KEY_BLOCK_SIZE = 0

MAX_ROWS = 0

MIN_ROWS = 0

ROW_FORMAT = Compact;



