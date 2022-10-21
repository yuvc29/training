-- 1
SELECT uid,
FROM orders
GROUP BY uid
ORDER BY COUNT(*)
DESC LIMIT 1

-- 2

select uid, sum(cost_price) as total
from (
	select uid, (order_amount*(1-discount/100.0) ) as cost_price
	from coupons
	inner join (
		select uid, cid, (order_amount)
		from orders
		inner join (
			select oid, sum(price) as order_amount
			from items
			inner join products on items.pid = products.pid
			group by oid
		) as join1 on join1.oid = orders.oid
	) as join1 on join1.cid = coupons.cid
) as join1
group by uid
order by total
desc limit 1

-- 3
SELECT pid
FROM items
GROUP BY pid
ORDER BY COUNT(*)
DESC/ASC LIMIT 1

-- 4
select uid, count(tid) as cnt_failed 
from 
(SELECT uid, tid
FROM transactions
INNER JOIN orders ON orders.oid = Transactions.oid
AND status = 'failed') as join1
group by uid


-- 5
select uid, sum(cost_price) as total
from (
	select uid, (order_amount*(discount/100.0) ) as cost_price
	from coupons
	inner join (
		select uid, cid, (order_amount)
		from orders
		inner join (
			select oid, sum(price) as order_amount
			from items
			inner join products on items.pid = products.pid
			group by oid
		) as join1 on join1.oid = orders.oid
		where ( 
			DATE_PART('month',  CURRENT_DATE) > DATE_PART('month',  order_date)
			AND DATE_PART('month',  CURRENT_DATE) - DATE_PART('month',  order_date)  < 6
			AND DATE_PART('year',  CURRENT_DATE) = DATE_PART('year',  order_date)
		)
		OR (
			DATE_PART('month',  CURRENT_DATE) < DATE_PART('month',  order_date)
			AND DATE_PART('month',  CURRENT_DATE) - DATE_PART('month',  order_date) +12 < 6
			AND DATE_PART('year',  CURRENT_DATE) - DATE_PART('year',  order_date) = 1
		)
	) as join1 on join1.cid = coupons.cid
) as join1
group by uid
order by total



-- 6
SELECT cid 
FROM coupons
WHERE valid_till < current_date

-- 7
select pid
from (select pid, AVG(rating) as avg_rating
	from items
	inner join reviews on items.iid = reviews.iid
	group by pid
	order by avg_rating
	desc limit 1
) as join1


-- 8
select oid 
from items
where quantity > 4
group by oid

-- 9
select category
from categories
INNER JOIN (
	Select pcid
	from items
	inner join products on products.pid IN (
		select pid
		from items
		inner join orders on orders.oid = items.oid
		where ( 
			DATE_PART('month',  CURRENT_DATE) > DATE_PART('month',  order_date)
			AND DATE_PART('month',  CURRENT_DATE) - DATE_PART('month',  order_date)  < 4
			AND DATE_PART('year',  CURRENT_DATE) = DATE_PART('year',  order_date)
		)
		OR (
			DATE_PART('month',  CURRENT_DATE) < DATE_PART('month',  order_date)
			AND DATE_PART('month',  CURRENT_DATE) - DATE_PART('month',  order_date) +12 < 4
			AND DATE_PART('year',  CURRENT_DATE) - DATE_PART('year',  order_date) = 1
		)
	)
	group by pcid
	order by COUNT(*)
	DESC LIMIT 1
) as join1
ON categories.pcid = join1.pcid



-- 10
SELECT uid
FROM users
WHERE uid NOT IN
(SELECT uid from orders)

-- 11
SELECT uid
FROM transactions
INNER JOIN orders ON orders.oid = transactions.oid
WHERE STATUS = 'failed'
GROUP BY uid

-- 12
SELECT * FROM users
WHERE DATE_PART('day',dob) = DATE_PART('day',CURRENT_DATE)
AND DATE_PART('month',dob) = DATE_PART('month',CURRENT_DATE);


(1,1,4)
(2,2,3)
(3,3,2)
(4,4,4)
(5,5,1)
