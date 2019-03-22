USE t1;

SELECT AVG(aa.real_number)
FROM
  (
    SELECT a.real_number, @row_num := @row_num + 1 AS 'row_number', @total_rows := @row_num
    FROM all_files a,
         (SELECT @row_num := 0) r
    ORDER BY a.real_number
  ) AS aa
WHERE aa.row_number IN (FLOOR((@total_rows + 1) / 2), FLOOR((@total_rows + 2) / 2));