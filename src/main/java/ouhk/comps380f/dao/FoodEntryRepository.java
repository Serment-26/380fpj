package ouhk.comps380f.dao;
public interface FoodEntryRepository {
    public void addEntry(GuestBookEntry e);

    public void updateEntry(GuestBookEntry e);

    public List<GuestBookEntry> listEntries();

    public GuestBookEntry getEntryById(Integer id);

    public void removeEntryById(Integer id);
}
