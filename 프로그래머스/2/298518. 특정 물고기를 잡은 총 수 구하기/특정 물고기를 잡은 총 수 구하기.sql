select count(*) as fish_count
from fish_info fi
join fish_name_info fni on fni.fish_type = fi.fish_type
where fni.fish_name in ('BASS', 'SNAPPER');