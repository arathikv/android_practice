//package com.example.newapp.pagination
//
//import android.annotation.SuppressLint
//import android.os.Bundle
//import android.view.View
//import android.widget.ProgressBar
//import android.widget.TextView
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.widget.NestedScrollView
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.android.volley.Request
//import com.android.volley.RequestQueue
//import com.android.volley.VolleyError
//import com.android.volley.toolbox.JsonObjectRequest
//import com.android.volley.toolbox.Volley
//import com.example.newapp.R
//import org.json.JSONException
//import org.json.JSONObject
//
//
//class PaginationActivity : AppCompatActivity() {
//    // creating a variable for our array list, adapter class,
//    // recycler view, progressbar, nested scroll view
//    private var userModalArrayList: ArrayList<UserModal>? = null
//    private var userRVAdapter: UserRVAdapter? = null
//    private var userRV: RecyclerView? = null
//    private var loadingPB: ProgressBar? = null
//    private var nestedSV: NestedScrollView? = null
//
//    // creating a variable for our page and limit as 2
//    // as our api is having highest limit as 2 so
//    // we are setting a limit = 2
//    var page = 0
//    var limit = 2
//    @SuppressLint("WrongViewCast", "MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_pagination)
//
//        // creating a new array list.
//        userModalArrayList = ArrayList()
//
//        // initializing our views.
//        val userid = findViewById<TextView>(R.id.idIVUser)
////       val userRV = findViewById<T>(R.id.idIVUser)
//        loadingPB = findViewById(R.id.idPBLoading)
//        nestedSV = findViewById(R.id.idNestedSV)
//
//        // calling a method to load our api.
//        getDataFromAPI(page, limit)
//
//        // adding on scroll change listener method for our nested scroll view.
////        nestedSV.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
////            // on scroll change we are checking when users scroll as bottom.
////            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
////                // in this method we are incrementing page number,
////                // making progress bar visible and calling get data method.
////                page++
//////                loadingPB.setVisibility(View.VISIBLE)
////                getDataFromAPI(page, limit)
////            }
////        })
//    }
//
//    private fun getDataFromAPI(page: Int, limit: Int) {
//        if (page > limit) {
//            // checking if the page number is greater than limit.
//            // displaying toast message in this case when page>limit.
//            Toast.makeText(this, "That's all the data..", Toast.LENGTH_SHORT).show()
//
//            // hiding our progress bar.
//            loadingPB!!.visibility = View.GONE
//            return
//        }
//        // creating a string variable for url .
//        val url = "https://reqres.in/api/users?page=$page"
//
//        // creating a new variable for our request queue
//        val queue: RequestQueue = Volley.newRequestQueue(this@PaginationActivity)
//
//        // creating a variable for our json object request and passing our url to it.
//        val jsonObjectRequest =
//            JsonObjectRequest(Request.Method.GET, url, null, object : Listener<JSONObject?>() {
//                fun onResponse(response: JSONObject) {
//                    try {
//
//                        // on below line we are extracting data from our json array.
//                        val dataArray = response.getJSONArray("data")
//
//                        // passing data from our json array in our array list.
//                        for (i in 0 until dataArray.length()) {
//                            val jsonObject = dataArray.getJSONObject(i)
//
//                            // on below line we are extracting data from our json object.
//                            userModalArrayList!!.add(
//                                UserModal(
//                                    jsonObject.getString("first_name"),
//                                    jsonObject.getString("last_name"),
//                                    jsonObject.getString("email"),
//                                    jsonObject.getString("avatar")
//                                )
//                            )
//
//                            // passing array list to our adapter class.
//                            userRVAdapter = UserRVAdapter(userModalArrayList!!, this@PaginationActivity)
//
//                            // setting layout manager to our recycler view.
//                            userRV!!.layoutManager = LinearLayoutManager(this@PaginationActivity)
//
//                            // setting adapter to our recycler view.
//                            userRV!!.adapter = userRVAdapter
//                        }
//                    } catch (e: JSONException) {
//                        e.printStackTrace()
//                    }
//                }
//            }, object : ErrorListener() {
//                fun onErrorResponse(error: VolleyError?) {
//                    // handling on error listener method.
//                    Toast.makeText(this@PaginationActivity, "Fail to get data..", Toast.LENGTH_SHORT)
//                        .show()
//                }
//            })
//        // calling a request queue method
//        // and passing our json object
//        queue.add(jsonObjectRequest)
//    }
//}
