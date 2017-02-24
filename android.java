
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
3. create xml layout 'cellView' that will desribe each row in 'listView' widget, add widgets
4. create java class that extends ArrayAdapter and set generic declaration to 'data' type
	4.1. declare two private fields, first will hold reference to List<'data'> object, second to LayoutInflater object
	4.2. public constructor should receive two arguments, Context object and List<'data'> object
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


		/*** PASS OBJECTS BETWEEN ACTIVITIES ***/
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


		/*** FRAGMENT. INITIALIZATION ***/
/*
1. xml layout file should define appearance of the fragment 
2. fragment controller java class extends Fragment superClass
	2.0. an empty public constructor is required
	2.1. @Override onCreateView method
		2.1.1. create an instance of View object and call inflate method on passed LayoutInflater argument, pass
			xml fragment layout resourse ID, ViewGroup argument and boolean value of attachToRoot argument
		2.1.2. return View`s reference variable

3. manage fragment not dynamically via activity xml layout file
	3.1. create a fragment widget with id, 'class' attr should contain full fragment`s controller class name,
		'tools:layout' attr should contain fragment`s xml layout file

4. manage fragment dynamically via manager class and manager xml layout
	4.1. add FrameLayout widget with unique id in manager xml layout, fragment will be injected here
	4.2. create public static final String tag with uniqe fragment identifier
	4.3. create an instance of fragment controller class and save to the reference variable
	4.4. get FragmentManager by calling getSupportFragmentManager method and save it to the reference variable
		4.4.1. call chained methods on fragment manager beginTransaction().
			add(container ID where to inject fragment, fragment controller instance var, unique tag).commit()
		4.4.2. in order to remove fragment by clicking back button in native android menu, add to chained call
			.addToBackStack(null) method just before .add() method
	4.5. if fragment controller already exist in manager class but out of scope,
		create a reference variable of type Fragment and call getSupportFragmentManager method on it,
		chained call to findFragmentByTag method with uniqe tag name
*/
		

		/*** FRAGMENT. RECEIVING DATA FROM MANAGER ***/
/*
1. fragment controller class should contain public static final String field as an unique identifier
2. manager class should call for empty constructor of Bundle object and save result in a reference variable
	2.1. call put'String'(unique str key, string object) method on 2. reference variable
3. create an instance of your fragment controller class and save ref to the reference variable
	3.1. call setArguments() method on frament`s controller ref var and pass ref var of type Bundle object
4. continue on from paragraph #4.4. in fragment init part
5. in fragment controller class create new var of type Bundle by calling getArguments() method
	5.1. retrieve string from Bundle object by calling getString(unique str key) on ref var from fifth paragraph
*/


		/*** FRAGMENT WITH FACTORY. RECEIVING DATA FROM MANAGER ***/
/*
1. fragment controller should create public static method that receive 'str' arg and return an inctance of it self
	1.1. call for empty constructor of Bundle object and save result in a reference variable
	1.2. call put'String'(unique str key, argument) method on Bundle`s object reference variable
	1.3. create an instance of fragment controller and save to the reference variable
	1.4. call setArguments() on fragment`s controller ref var and pass Bundle`s ref var as an argument
	1.5. return fragment`s controller ref var
2. manager class should create a ref var of type fragment controller and call static method from it and passing str obj
*/


		/*** FRAGMENT. SENDING DATA TO MANAGER ***/
/*
1. declare a callback interface in fragment controller with method that return nothing and receive required objects
2. declare a private field in fragment controller that hold inctance of callback object that confirms to that interface
3. override onAttach method in fragment controller that receive context object
	3.1. check if argument is instanceof required callback interface, if not throw new AssertionError()
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
2. call putString() method on this ref var and pass 'value str key' and a value
3. call apply() method on this ref var

4. in order to retreive value from shared prefs define ref var of type SharedPreferences and call 
	getSharedPreferences() method with 'str key' and mode
5. call getString() method on this ref var, pass 'value str key' and default value
*/
