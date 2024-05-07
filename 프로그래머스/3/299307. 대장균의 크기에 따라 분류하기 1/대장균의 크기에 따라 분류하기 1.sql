select ID, (
    case
    when ed.SIZE_OF_COLONY <= 100 then 'LOW'
    when ed.SIZE_OF_COLONY > 100 and ed.SIZE_OF_COLONY <= 1000 then 'MEDIUM'
    else 'HIGH'
    end) as SIZE
from ECOLI_DATA ed
order by ed.ID;