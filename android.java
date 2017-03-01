
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


		/*** LIST VIEW ***/
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


		/*** RECYCLE VIEW ***/
/*
1. in main activity add recycler view widget with id and tag <app:layoutManager="LinearLayoutManager"/>
2. create 'list_item' xml that will represent each item in recycler view, add widgets with id`s
3. create 'data_item' java file that will represent your custom data type, add constructor, getters/setters
4. creare 'data_adapter' java file, extends RecyclerView.Adapter<'inner_class'>
	4.1. add public static 'inner_class', extends RecyclerView.ViewHolder
		4.1.1. declare public fields that will hold ref to the widgets from 'list_item' xml
		4.1.2. declare public field that will hold ref to View obj
		4.1.3. add public constructor that receive View obj as an arg
			4.1.3.1. call super class constructor
			4.1.3.2. bind public fields to widgets
			4.1.3.3. bind View obj to class public field
	4.2. declare private fields for List<'data_item'> and Context obj
	4.3. add constructor that receive Context obj and List<'data_item'> as an args
		4.3.1. save args to the private fields
	4.4. @Override all three required methods
		4.4.1. in onCreateViewHolder() create ref var of type LayoutInflater and obtain the LayoutInflater from 
			the given Context obj by calling from() method on LayoutInflater and passing mContext from public field
			4.4.1.1 create ref var of type View and call inflater.inflate('int resource layout', 
				'view to be the parent of the generated hierarchy', 'boolean value for attachToRoot');
			4.4.1.2. create ref var of type ViewHolder by calling constructor with ref var of type View argument
			4.4.1.3. return ref var of type ViewHolder
		4.4.2. in onBindViewHolder() create ref var of type 'data_item' by calling get() method on List<'data_item'>
			private field and passing 'int position' as an arg
			4.4.2.1. use data by calling 'setText' on passed arg ('inner_class') public field
			4.4.2.2. setOnClickListener() on passed arg ('inner_class') public field and call Intent obj
		4.4.3. in getItemCount() return size of List<'data_item'> private field
5. in activity that holds recycler view widget init ref var of 'data_adapter' by calling constructor that receive
	 Context obj and List<'data_item'>
	5.1. bind RecyclerView widget to the ref var
	5.2. call setAdapter() method on RecyclerView ref var and pass 'data_adapter' ref var as an argument
*/


		/*** RECYCLE VIEW IN FRAGMENT ***/
/*
1. create xml file with FrameLayout and id 'fragment_container', this will be one injection point for all fragments
2. create abstract 'SingleFragmentActivity' class, extends AppCompatActivity, generic class that dynamically 
	binds one fragment constainer with any fragment controller on runtime
	2.1. add abstract 'createFragment()' method that return Fragment obj and receive no args
	2.2. override onCreate() method
		2.2.1. declare ref var 'manager' of type FragmentManager and call getSupportFragmentManager() method
		2.2.2. declare ref var 'fragment' of type Fragment and call findFragmentById('fragment_container') method 
			on 'manager' ref var
		2.2.3. check if 'fragment' is equal to null, if true, call 'createFragment()' abstract method, save returned
			obj into 'fragment' ref var
			2.2.3.1. chained call beginTransaction().add('fragment_container', 'fragment ref var', null)
				.commit() methods on 'manager' ref var

2. create concrete class 'ListActivity', add it to the manifest xml with <activity> tag, extends 
	'SingleFragmentActivity' abstract class
	2.1. override anstract method 'createFragment()' and return new instanse of your fragment controller class
		'ListFragment', at this point we binding fragment`s controller class to the fragment activity xml file

3. create fragment controller class 'ListFragment', extends Fragment, this class will nest RecyclerView.ViewHolder
	and RecyclerView.Adapter inner classes in order to implement RecyclerView widget in fragment
	3.1. add private field of type RecyclerView
	3.2. add private field of type 'YourAdapter'
	3.3. override onCreateView() method
		3.3.1. declare raf var 'view' of type View and call inflate() method on arg of type LayoutInflater,
			pass xml layout name that should be injected, arg of type ViewGroup, false. At this point we define
			what kind of content would be shown in created generic fragment container
		3.3.2. bind ref var in private field of type RecyclerView with widget in xml, find by id
		3.3.3. call setLayoutManager() method on ref var of type RecyclerView 
			and pass new instance of 'linear' layout manager with getActivity() parameter
		3.3.4. declare ref var of type 'YourSingletonObj' and call static method from that class in order to get
			instance of this obj. That obj should contain array of all custom 'data' objects in app.
			Pass getActivity() as a parameter
		3.3.5. declare List<'data'> objects and get it from 'YourSingletonObj' instance, by calling expected method
		3.3.6. update private field of type 'YourAdapter' by calling constructor of RecyclerView.Adapter inner class
			and pass List<'data'> objects
		3.3.7. call setAdapter() method on private field ref var of type 'RecyclerView' and pass 'YourAdapter'
			private field ref var

4. create inner class 'YourAdapter' extends RecyclerView.Adapter<'YourHolder'>
	4.1. declare private field of type List<'data'>
	4.2. add public constructor that receive List<'data'> as an argument
		4.2.1. bind passed argument with private field
	4.3. override onCreateViewHolder() method that will be called each time when RecyclerView needs a new view
		for each obj in List<'data'>
		4.3.1. declare ref var 'layout_inf' of type LayoutInflater and call LayoutInflater.from(getActivity())
		4.3.2. return new 'YourHolder' obj while passing layout_inf ref var and arg of type ViewGroup
	4.4. override onBindViewHolder() method that will be called by RecyclerView to display at the specified position
		4.4.1. declare ref var of type 'data' and call get() method on private field of type List<'data'> while
			passing current position int value from argument
		4.4.2. call bind() method on 'YourHolder' arg and pass ref var of type 'data'
	4.5. override getItemCount() method and return size of private field of type List<'data'>

5. create inner class 'YourHolder' extends RecyclerView.ViewHolder implements View.OnClickListener that will be
	describes an item view and metadata about its place within the RecyclerView
	5.1. declare private fields of required widgets type
	5.2. declare private field of type 'data' object
	5.3. add public constructor that receive LayoutInflater obj and ViewGroup obj as an args
		5.3.1. call super class constructor and pass inflate('layout xml of cell', 'ViewGroup ref var', false) method
			on LayoutInflater ref var
		5.3.2. use public final field 'itemView' of type View from ViewHolder super class for binding all
			private fileds with widgets
		5.3.3. call setOnClickListener() method on 'itemView' and pass 'this' as an arg
	5.4. declare bind() method that receive 'data' obj as an arg and return void
		5.4.1. bind private field of type 'data' obj with passed arg of type 'data' obj
		5.4.2. use data to update widgets in each cell
	5.5. override onClick() method, call getActivity() in order to get fragment that currently associated with









*/


		/*** NEW ACTIVITY ***/
/*
0. create xml layout taht will represent new activity
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


		/*** FRAGMENT. INITIALIZATION ***/
/*
1. create new xml layout file that will define appearance of the fragment 
2. create fragment controller java class, extends Fragment superClass
	2.0. an empty public constructor is required
	2.1. @Override onCreateView() method
		2.1.1. create an instance of View obj and call inflate() method on passed LayoutInflater arg, pass
			xml fragment layout resourse ID, ViewGroup argument and boolean value of attachToRoot argument
		2.1.2. return View`s reference variable

3. manage fragment not dynamically via activity xml layout file
	3.1. create a fragment widget with id, 'class' attr should contain full fragment`s controller class name,
		'tools:layout' attr should contain fragment`s xml layout file

4. manage fragment dynamically via manager class and manager xml layout
	4.1. add FrameLayout widget with unique id in manager xml layout, fragment will be injected here
	4.2. create public static final String tag with unique fragment identifier
	4.3. create an instance of your fragment controller class and save to the ref var
	4.4. get FragmentManager by calling getSupportFragmentManager method and save it to the ref var
		4.4.1. call chained methods on fragment manager 
			beginTransaction().add(container ID where to inject fragment, 
				fragment controller instance var, unique tag).commit()
		4.4.2. in order to remove fragment by clicking back button in native android menu, add to chained call
			.addToBackStack(null) method just before .add() method
	4.5. if fragment controller already exist in manager class but out of scope,
		create a ref var of type Fragment and call getSupportFragmentManager method on it,
		chained call to findFragmentByTag method with uniqe tag name
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


		/*** SHARED PRIFERENCES ***/
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
