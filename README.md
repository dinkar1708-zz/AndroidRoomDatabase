# Saving Data Using the Room Persistence Library
Room provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.

There are 3 major components in Room:
1. Database
2. Entity
3. Dao

# In existing project - 
Very basic usages and setup of room data base has been shown via user example.

Basic crucks-

*. Setup of data base

AppDatabase - create db
```
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "database-name").build();             
```

*. UserDao - interface to provide access on db-
```
@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();
 ```
//init service

*. Initilize service where you want to use room db- 
```
private UserServiceImpl userService;
userService = new UserServiceImpl(LoginActivity.this);
```

*. From do in background save objects in db

                User user = new User();
                user.setUid(new Random().nextInt());
                user.setEmail(mEmail);
                user.setPassword(mPassword);
                user.setFirstName("First Name");
                user.setLastName("Last Name");
                userService.insertAll(user);
                users = userService.getAll();
                
*. Simple method to get db in background thread and showing data on UI-
```
 private void getUsersFromDB() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                users = userService.getAll();
                return null;
            }
            @Override
            protected void onPostExecute(Void agentsCount) {
                usersTextView.setText("Users \n\n " + users);
            }
        }.execute();
```        

                
# https://developer.android.com/images/training/data-storage/room_architecture.png


# Screen shots

![device-2018-01-25-202154](https://user-images.githubusercontent.com/28217318/35485232-a43a6d02-0482-11e8-84f8-8dbc2773d90b.png)

![device-2018-01-25-202231](https://user-images.githubusercontent.com/28217318/35485233-a4647a48-0482-11e8-8742-8e0167137e5f.png)

![device-2018-01-25-202311](https://user-images.githubusercontent.com/28217318/35485234-a48ee472-0482-11e8-9a20-4209dec75dcb.png)
