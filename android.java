
		/*** SCREEN UTILITIES. GET SCREEN SIZES ***/
/*
1. create new class with two private fields: dpWidth and dpHeight of type float
2. create constructor with Activity object as an argument
	2.1. get instance of Display object and save it to the ref var by calling chained method 
		getWindowManager() and getDefaultDisplay() on passed argument
	2.2. get new instance of DisplayMetrics object and save it to the ref var by calling empty constructor
	2.3. call getMetrics() method on Display ref var and pass DisplayMetrics ref var as an argument
	2.4. calc density var of type float by calling getResources().getDisplayMetrics().density on passed argument
	2.5. calc private fields by calling 'width'Pixels property on DisplayMetrics ref var, devided by density var
3. create getter methods for private fields
*/


		/*** NETWORK UTILITIES. CHECK NETWORK AVAILABILITY AND WIFI ONLY ***/
/*
0. update manifest file with <uses-permission android.permission.ACCESS_NETWORK_STATE and INTERNET/>
1. add protected no argument method that return boolean value
2. create an instance of ConnectivityManager ('cm') by calling getSystemService(Context.CONNECTIVITY_SERVICE) 
	method and save it to the ref var
3. create an instance of NetworkInfo ('ni') by calling getActiveNetworkInfo() method on 'ni' and save it 
	to the ref var
4. check if ('ni' != null && ni.isConnectedOrConnecting())
5. check if ('ni'.getType() != ConnectivityManager.TYPE_WIFI) return false and display a message that no wi-fi
*/


		/*** SAVE INSTANCE STATE ***/
/*
1. override onSaveInstanceState(argument of type Bundle) method, add logic befor call to super method
	1.1. call put'Strint'() method on argument and private static final String constant as a key and a value
2. override onRestoreInstanceState(argument of type Bundle) method, add logic after call to super method
	2.1. call get'String'() method on an argument and pass constant as a key
*/


		/*** DIALOG FRAGMENT BOX ***/
/*


*/





		/*** NEW ACTIVITY ***/
/*
0. create xml layout that will represent new activity
	0.1. add this xml into manifest file with <android:parentActivityName/>
1. create public java class, extend AppCompatActivity, override onCreate(), it should controll new activity xml layout
	1.1. declare private final static String for future Intent (from initial to called activity) identification
	1.2. declare private final static String for future Intent (from called to initial activity) identification
	1.3. add public static method 'intentCallBack'() that will take Context obj and 'String' data value
		1.3.1. call Intent constructor, pass Context of the application package implementing this class and
			the component class that is to be used for the intent, save result in ref var
		1.3.2. call putExtra() method on this ref var and pass key str of the extra data and 'String' data value
		1.3.3. return ref var
2. inside 'init activity' declare private final static int as a 'requestCode' for Intent identification
	2.1. call static 'intentCallBack'() method from 'called activity', pass context and 'String' data value, 
		save result as ref var
	2.2. call startActivityForResult() method and pass new ref var of Intent obj and 'requestCode' arg as an int value
3. inside 'called activity' call getIntent() method that return the intent that started this activity, chained call
	get'String'Extra() method, pass key str for retrieving passed 'String' data value and save result in rev var
	3.1. use reveived data

4. in order to send data back from 'called activity' to 'init activity' after user press back button
	4.1. declare new Intent object and call no argument constructor, save result in ref var
	4.2. call putExtra() method on this ref var and pass key str of the extra data and 'String' data value
	4.3. call setResult() method to set the result that 'called activity' will return to its caller and pass
		RESULT_OK constant and Intent ref var
5. inside 'called activity' declare static method that will take Intent obj as an arg and return a 'String'
	5.1. call getStringExtra() method on Intent arg and pass key str of the extra data, return result
6. inside 'init activity' override onActivityResult() method that receive arguments: 
	'requestCode' arg (int request code originally supplied to startActivityForResult(), 
		allowing to identify who this result came from
	'resultCode' arg int result code returned by the child activity through its setResult()
	'data' an Intent which can return result data to the caller
	6.1. check if 'requestCode' arg is uequal to constant key for current Intent identification
	6.2. call static method from 'called activity' pass 'data' Intent arg and save result in ref var
	6.3. use data
*/


		/*** PASS PARCELABLE OBJECTS BETWEEN ACTIVITIES ***/
/*
1. create java class that will represent your custom data type ('data'), add constructor, getter/setter methods
2. in auto generate menu choose parcelable option, select required fields
3. while calling putExtra() method in 'init activity' pass unique str key and 'data' object as parameters
4. in 'called activity' call getIntent().getExtra().getParcelable('str key') and save result in ref var of type 'data'
5. use data
*/


		/*** ASYNC TASK. SERIAL AND PARALLEL ***/
/*
1. declare a class that extends AsyncTask with three generic parameters <input type, progress, return type>
2. onPreExecute() will be executed before background thread, can communicate with UI
3. doInBackgroud() receive a list of tasks (args) and return a value, the same type as AsyncTask class signature
	3.1. will be executed on backgroud thread, no comminication with UI
	3.2. call publishProgress() method and pass each task (arg) at a time (using for-loop and arr index)
	3.3. override onProgressUpdate() that receive a list of args, index first arg from a list of args and undate UI
4. onPostExecute() that receive argument the same type as AsyncTask class signature, can communicate with UI
5. instantiate class that extends AsyncTask and save in instance variable
	5.1. call execute(arguments list) method on instance variable, will work serially, one task after another
	5.2. call executeOnExecuter(AsyncTask.THREAD_POOL_EXECUTOR, arguments list) method on instance var for parallel
*/


		/*** ASYNC TASK WITH FRAGMENT ***/
/*
1. create 'controller' java class, extends Fragment super class, should contain public empty constructor
2. create an interface with one method that returns void and receive one arg of type 'String' obj
3. declare private field of type 'interface'
4. @Override onCreate() method and call setRetainInstance() method with boolean parameter
5. @Override onAttach() and call super class constructor, pass Context obj
	5.1. check if arg of type Context is instanceof 'interface', if not throw new AssertionError()
	5.2. save arg of type Context obj to the private field  of type 'interface'
6. implement public method 'task' that receive varargs of type 'String' and return void
	6.1. initialize private nested class by calling no arg constructor, save in ref var
	6.2. execute() method on ref var and pass varargs
7. declare private nested class that extends AsyncTask<'String', 'String', 'String'>
	7.1. @Override doInBackground() method and pass varargs of 'String' type
		7.1.1. create a for-each loop and iterate over each varargs argument
		7.1.2. call publishProgress() method and pass each iterable obj
	7.2. @Override onProgressUpdate() method and pass varargs of 'String' type
		7.2.1. call method from 'interface' declaration on private field of type 'interface'

7. in main activity class implement 'interface'
	7.1. @Override method from 'interface' and use data from passed argument
	7.2. add private static final TAG field for fragment identification
	7.3. add private field of type 'controller'
	7.4. get FragmentManager by calling getSupportFragmentManager() method and save into ref var
	7.5. bind private field of type 'controller' by calling findFragmentByTag() method on FragmentManager ref var
		and pass TAG field
	7.6. check if private field of type 'controller' is equal to null, if true, call 'controller' constructor 
		and save result in private field of type 'controller'
	7.7. chained call beginTransaction().add(private field of type 'controller', TAG).commit() 
		on ref var of type FragmentManager
8. set setOnClickListener() and call 'task' method from 'controller' class, pass args
*/



		

		/*** FRAGMENT. RECEIVING SIMPLE DATA FROM MANAGER ***/
/*
1. fragment controller class should contain public static final String field as an unique identifier
2. manager class should call for empty constructor of Bundle object and save result in a ref var
	2.1. call put'String'('unique str key', string object) method on ref var of type Bundle
3. create an instance of your fragment controller class and save to the ref var
	3.1. call setArguments() method on frament`s controller ref var and pass ref var of type Bundle obj
4. continue on from paragraph #4.4. in fragment init part
5. in fragment controller class create new var of type Bundle by calling getArguments() method
	5.1. retrieve string from Bundle object by calling getString('unique str key') on ref var of type Bundle
*/


		/*** FRAGMENT WITH FACTORY. RECEIVING SIMPLE DATA FROM MANAGER ***/
/*
1. fragment controller should create public static method that receive 'str' arg and return an inctance of itself
	1.1. call for empty constructor of Bundle object and save result in a reference variable
	1.2. call put'String'(unique str key, argument) method on Bundle`s object reference variable
	1.3. create an instance of fragment controller and save to the reference variable
	1.4. call setArguments() on fragment`s controller ref var and pass Bundle`s ref var as an argument
	1.5. return fragment`s controller ref var
2. manager class should create a ref var of type fragment controller and call static method from it and passing str obj
*/


		/*** FRAGMENT. SENDING SIMPLE DATA TO MANAGER ***/
/*
1. declare a callback interface in fragment controller with method that return nothing and receive required objects
2. declare a private field in fragment controller that hold inctance of callback object that confirms to that interface
3. override onAttach method in fragment controller that receive context object
	3.0. call super class constructor and pass context as an arg
	3.1. check if arg is instanceof required callback interface, if not throw new AssertionError()
	3.2. save context argument object to the private field reference variable of type callback interface
4. implement callback iterface in manager class and use arguments in code
5. in fragment controller call implemented iterface method on ref var that holds callback object and pass required args
*/


		/*** HTTP CONNECTION. STRING DATA AND SIMPLE AUTH ***/
/*
1. daclare a BufferedReader ref var and assign a null
2. declare a byte array and call getBytes() method on a concatenated Strings arguments
3. declare a StringBuilder ref var by calling chaned methods
	no arg constructor.apped("Basic").append(Base64.encodeToString(byte arr ref var, Base64.DEFAULT))
4. in try block create a new URL obj by calling constructor that receive a string as an argument
	4.1. create HttpURLConnection obj by calling openConnection() method on URL instance var
	4.2. call addRequestProperty("Authorization", StringBuilder ref var with toString method) on prev ref var
	4.2. declare and initialize a StringBuilder object
	4.3. call constructor of BufferedReader obj that receive new InputStreamReader obj that receive 
		HttpURLConnection.getInputStream()
	4.4. create a new String object
	4.5. while (String obj = reader.readLine()) not equal to null, append line to StringBuilder ref var
	4.6. return StringBuilder ref var with toString() method call
5. in final block call close() method on BufferedReader ref var
*/


		/*** HTTP CONNECTION. BITMAP IMAGE ***/
/*
0. all code must be placed in background thread, doInBackgroud() method for example
	0.1. class that describe your specifit obj should contain private field of type Bitmap with setter/getter methods
1. declare a string url for exact image
2. declare a ref var of type InputStream and call constructor of URL object with image url string argument, 
	chained by getContent() method call
3. declare a ref var of type Bitmap and call BitmapFactory.decodeStream(ref var of type InputStream)
4. set new property to your Object
5. close InputStream object
6. get reference to ImageView widget and call setImageBitmap() method on it
*/


		/*** SHARED PREFERENCES ***/
/*
1. define SharedPreferences.Editor instance by calling getSharedPreferences() method, pass 'str key' and mode, 
	chained call edit() method, save result in ref var
2. call put'String'() method on this ref var and pass 'str key' and a value
3. call apply() method on this ref var

4. in order to retreive value from shared prefs define ref var of type SharedPreferences and call 
	getSharedPreferences() method with 'str key' and mode
5. call getString() method on this ref var, pass 'str key' and default value
*/


		/*** SQLITE DATA BASE ***/
/*
1. create java class that will represent your custom data type ('data') with private fields and getters/setters
	1.1. add toValues() no argument method, inside create ref var of type ContentValues by calling
		constructor with number of raws in the db table
	1.2. call put() method on ref var and pass 'key' the name of the value to put and value the data
2. create java class that will hold SQlite base commands as a public static final fields
	2.1. SQL_CREATE field should contain SQLite command "CREATE TABLE " + TABLE_ITEMS + "(" +
            COLUMN_ID + " TEXT PRIMARY KEY," +
            COLUMN_NAME + " TEXT," +
            COLUMN_POSITION + " INTEGER," +
            COLUMN_PRICE + " REAL," +
            COLUMN_IMAGE + " TEXT" + ");";
    2.2. public static final String SQL_DELETE = "DROP TABLE " + TABLE_ITEMS
3. create java class that will manage SQLite database, extends SQLiteOpenHelper
	3.1. add two public static final fields 'DB_FILE_NAME' and 'DB_VERSION'
	3.2. add one argument constructor that receive Context obj and call super class constructor with args
		Context obj, name of the db, factory for creating cursor obj or null for the default, version number of the db
	3.3. @Override onCreate('db') method and call execSQL('SQL_CREATE command') on 'db' arg
	3.4. @Overrideo nUpgrade() method and call execSQL('SQL_DELETE command') on 'db' arg
4. create java class that will manage SQlite 'data source'
	4.1. add two private fields of type Context and SQLiteDatabase, one public field of type SQLiteOpenHelper
	4.2. create constructor that will receive Context as an argument
		4.2.1. save ref of the Context obj to the private field
		4.2.2. initialize public field of type SQLiteOpenHelper by calling your SQLite db manager class constructor
		4.2.3. initialize private field of type SQLiteDatabase by calling getWritableDatabase() method
			on ref var of type SQLiteOpenHelper
	4.3. create open() method that will inititialize private field of type SQLiteDatabase by calling 
		the same methods as constructor do
	4.4. create close() method that will close() method on ref var of type SQLiteOpenHelper
	4.5. create createItem() method that will return ref var of your custom type 'data' and receive ref var same type
		4.5.1. init ref var of type ContentValues by calling toValues() method on passed argument and save it
		4.5.2. call insert() method on ref var of type SQLiteDatabase and pass str 'table' to insert the row into,
			null, ref var of type ContentValues
5. in main activity class define ref var of your custom SQlite 'data source' type
6. call your SQLite 'data source' constructor, pass context obj as an arg and save result in ref var
		of your custom SQlite 'data source' type
5. use open() and close() db`s methods inside onPause() and onResume() methods in order to privent db leaks
*/



		/*** FRAGMENT SINGLE VIEW ***/
/*
define 'host_layout' where fragments will be injected
define 'content_layout' with widgets, this one will be injected
define abstract 'any_fragment_activity' class with boilerplate code
	add abstract method that return instance of Fragment obj
	onCreate() pass 'host_layout' to the setContentView()
	get fragment manager
	find fragment instance by passing ID of 'host_layout' to the manager
	start a series of edit operations add 'where' and 'what'
define concrete 'your_fragment_activity' class
	override abstract method that return instance of 'your_fragment_controller'
define 'your_fragment_controller'
	add static newInstance() that return new instance of itself
	onCreateView() get View obj by inflating 'content_layout'
*/



		/*** RECYCLE VIEW IN FRAGMENT ***/
/*
define FrameLayout layout, fragments will be injected here
define RecyclerView layout, this one will be injected
define LinearLayout layout, this one will hold each cell view
define DataItem class, should describe your data
define DetaItemList singleton class
	add private static field of itself`s type
	add private static field of type List<Gen>
	add private constructor, initialize List<Gen> private field
	add public static getInstance(Context) method, check if instance of itself is null, if true, call constructor
	add methods to get nesessery fields
define abstract GenericActivity class, with abstract method that return Fragment obj and boilerplate code
	get fragment manager, find fragment by passing ID of layout where fragment will be injected
	check for null, call abstract method, start a series of edit operations add 'where' and 'what'
define concrete FragmentActivity class, override abstract method that return instance of FragmentController
define concrete FragmentController class, will hold RecyclerView.Adapter and RecyclerView.ViewHolder
	add public static method that return instance of itself
	add private field of type List<Gen>
	override onCreate() initialize List<Gen> private field by calling static getInstance(Context) method from 
		DetaItemList singleton class
	define private inner class RecyclerView.ViewHolder, will describe each cell view
		add private field of widget type from cell view layout
		add private field of DataItem class
		add constructor that receive LayoutInflater and ViewGroup as args
			call super constructor and pass LayoutInflater.inflate('cell view layout', 'where', false)
			bind each private field of widget type by finding ID from itemView ref var
		add bindMethod() method that receive DataItem arg
			bind private field of type DataItem class with passed arg
			use data fields from DataItem class to populate UI
	define private inner class RecyclerView.Adapter<RecyclerView.ViewHolder>
		override onCreateViewHolder(), get LayoutInflater obj by calling from() method and pass current fragment
			return new instance of RecyclerView.ViewHolder inner class, pass LayoutInflater and ViewGroup objs
		override onBindViewHolder(), get DataItem obj by calling get() method on private field of type List<Gen>
			and pass position arg
		override getItemCount(), return size of List<Gen>
	override onCreateView(), get View obj by inflating RecyclerView fragment layout
		bind RecyclerView with controller by finding widget ID
		set layout manager on RecyclerView ref var
		call RecyclerView.Adapter constructor and save in ref var
		call setAdapter() method on RecyclerView ref var and pass adapter
		return View obj
*/



		/*** LIST VIEW IN FRAGMENT ***/

/*




1. create java class that will represent your custom data type ('data')
2. create xml layout that will hold ListView widget ('listView')
3. create xml layout 'cellView' that will desribe each row in 'listView', add widgets
4. create java class that extends ArrayAdapter and set generic declaration to 'data' type
	4.1. declare two private fields, first will hold reference to List<'data'> object, second to LayoutInflater obj
	4.2. public constructor should receive two args, Context obj and List<'data'> obj
		4.2.1. call super class constructor and pass context, 'cellView' layout recource, List<'data'> object
		4.2.2. save List<'data'> object argument to the private field
		4.2.3. save LayoutInflater.from(context) to the private field
	4.3. override getView('position of each row', 'cellView', 'parent view') method
		4.3.1 get current object from List<'data'> by referencing current position in array, save to ref var
		4.3.2. connect your widgets from 'cellView' with ref vars
		4.3.3. update data in widgets
		4.3.4. return 'cellView' ref var
5. create java file that will call onCreate() method, connect ListView widget with ref var
	5.1. call your custom ArrayAdapter class constructor, pass context and ListArray, save to ref var
	5.2. call setAdapter() method on ListView widget ref var and pass your custom adapter

*/



		/*** MVVM DATA BINDING ***/
/*

0. add into grandle file 'dataBinding {enable = true}' statement

1. define generic xml that will host any fragment. FrameLayout should be used to display a single item.
	1.1.  xml 'activity_layout' with unique id

2. define xml 'recycler_layout' with RecyclerView widget. Wrap all content in <layout> tag
	2.1. IDE will generate a binding class 'RecyclerLayoutBinding'

3. define controller for your fragment, it will hold RecyclerView.Adapter and RecyclerView.ViewHolder
	3.1. fragment controller 'recycler_fragment', extends Fragment
	3.2. add public static no argument method newInstance() that will return new instance of your fragment controller

4. at this point we have to define where 'recycler_fragment' should be injected
	4.1. define abstract 'single_frag_activity' class, extends AppCompatActivity. It will hold boilerplate for any
		fragment activity class
		4.1.1. add abstract no argument createFragment() method that will return obj of type Fragment 
		4.1.2. override onCreate() method, pass your generic 'activity_layout' as an arg to the setContentView() method
		4.1.3. get 'fragment_manager' by calling getSupportFragmentManager() method and save it in ref var
			of required type for interacting with fragments associated with this activity
		4.1.4. find 'fragment' that was identified by id either when inflated from XML or as the container ID 
			when added in a transaction. Call findFragmentById('frameLayout id from activity_layout') method on
			ref var of type 'fragment_manager' and save result in new ref var
		4.1.5. check if 'fragment' equals to null, if true create new instance by calling abstruct class and save return
			value into 'fragment' ref var
		4.1.6. start a series of edit operations on the 'fragment' associated with this 'fragment_manager'
	4.2. define concrete 'fragment_activity' class, extends 'single_frag_activity'. Override abstract method and return
		instance of your 'recycler_fragment' by calling static method

5. next job is to inflate 'recycler_layout' into 'activity_layout' using data binding, working with 'recycler_fragment'
	5.1. binding class 'RecyclerLayoutBinding' will have two refs getRoot() method and 'recyclerView', 
		first refers to the entire layout, second to just one widget
	5.2. override onCreateView() method, initialize instance of 'RecyclerLayoutBinding' class by calling 
		DataBindingUtil.inflate(LayoutInflater, 'recycler_layout', ViewGroup, false) method and save result 'binding'
	5.3. call setLayoutManager() method on 'binding'.'recyclerView' and pass layout manager constructor
		5.3.1. if layout manager constructor requires Context as an arg, call getActivity() method
	5.4. return 'binding'.getRoot()

6. now lets define how each view in RecyclerView will be looks like
	6.1. create new xml layout 'item_layout', wrap all content in <layout> tag, add widgets
	6.2. IDE will generate a binding class 'ItemLayoutBinding'

7. wired up 'item_layout' to inner private class 'ViewHolder', extends RecyclerView.ViewHolder
	7.1. declare private field that will hold ref to 'ItemLayoutBinding' class
	7.2. add private constructor that will take 'ItemLayoutBinding' class as an arg ('binding')
		7.2.1. call super constructor and pass 'binding'.getRoot() method
		7.2.2. update private field of type 'ItemLayoutBinding' with received arg

8. create 'ViewAdapter' inner private class, extends RecyclerView.Adapter<'ViewHolder'>
	8.1. override onCreateViewHolder()
		8.1.1. obtains LayoutInflater from the given context by calling from() method on LayoutInflater obj and
			pass getActivity() method
		8.1.2. initialize instance of 'ItemLayoutBinding' class by calling 
			DataBindingUtil.inflate(LayoutInflater, 'item_layout', ViewGroup, false) method and save result 'binding'
		8.1.3. return new constructor of 'ViewHolder' class and pass 'binding' ref var
	8.2. override onBindViewHolder()
	8.3. override getItemCount()
	8.4. now we can wire 'ViewAdapter' in onCreateView() method from 'recycler_fragment' controller
		8.4.1. call setAdapter() method on 'binding'.'recyclerView' and pass constructor of your 'ViewAdapter'
			inner class with no args

9. add new assets into 'sample_assets' derectory

10. create 'Box' class that will find assets, keep track of them and play sounds
	10.1. 




*/

