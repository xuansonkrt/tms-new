ALTER TABLE `db_tms`.`staff_paper` 
ADD COLUMN `research_point` DECIMAL(10,2) NULL AFTER `modified_by`;


ALTER TABLE `db_tms`.`staff_paper` 
ADD COLUMN `paper_type_id` BIGINT(20) NULL AFTER `research_point`;
