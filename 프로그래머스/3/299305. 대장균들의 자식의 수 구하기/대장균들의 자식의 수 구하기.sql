select ID, (
    select count(*) 
    from ecoli_data target
    where target.PARENT_ID = ed.ID) CHILD_COUNT
from ecoli_data ed
order by ed.ID;
