package ouhk.comps380f.dao;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import ouhk.comps380f.model.FoodEntry;

public interface FoodEntryRepository {
    public void addEntry(FoodEntry e);

    public void updateEntry(FoodEntry e);

    public List<FoodEntry> listEntries();

    public FoodEntry getEntryById(Integer id);

    public void removeEntryById(Integer id);
}
