
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


		/*** NEW ACTIVITY ***/
/* INITIAL_ACTIVITY
2. call static method from calledActivity pass current context and value, get Intent instance
3. start new activity (startActivityForResult), pass Intent instance and request code (int const) for future tracking
7. @Override onActivityResult(requestCode, resultCode, Intent) for all callbacks from all Activities
	check if requestCode is correct and call static method from calledActivity, pass Intent as an agr, save result
8. use result in initialActivity

CALLED_ACTIVITY
1. create static method that receive initialActivity context and value as parameters
	init new Intent object, pass context and current calledActivity.this object
	put extra value (key const str - value argument)
	return new instance

4. as activity created call getIntent().get"Boolean"Extra, pass key-const-str and default value if failed, save result
5. prepare for answer back, create new Intent instance and save reference to it
	put extra values for returning back to initialActivity (key const str - value)
	call setResult method and pass RESULT_OK status and ref to new created Intent instance
	call static method for answer handling
6. create static method for answer handling that receive created Intent instance and return boolean
	return result of instance.get"Boolean"Extra(key-const-str, default value if failed)
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


		/*** XML PARSER ***/
/*

*/


		/*** JSON PARSER ***/
/*

*/

