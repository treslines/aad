package br.com.programadordeelite.gdc.codelab.core.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import br.com.programadordeelite.gdc.R
import kotlinx.android.synthetic.main.fragment_notification.*

private const val NOTIFICATION_ID = 0
private const val PRIMARY_CHANNEL_ID = "primary_notification_channel"
private const val ACTION_UPDATE_NOTIFICATION = "ACTION_UPDATE_NOTIFICATION"
private const val ACTION_DELETED_NOTIFICATIONS = "ACTION_DELETED_NOTIFICATIONS"

class NotificationFragment : Fragment(R.layout.fragment_notification) {

    private lateinit var mNotifyManager: NotificationManager
    private val notificationReceiver = NotificationReceiver()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUiButtonListeners()
        setupUiButtonStates(enableNotify = true, enableUpdate = false, enableCancel = false)
        createNotificationChannel()
        registerNotificationReceiver()
    }

    private fun setupUiButtonListeners() {
        notify.setOnClickListener { sendNotification() }
        update.setOnClickListener { updateNotification() }
        cancel.setOnClickListener { cancelNotification() }
    }

    private fun registerNotificationReceiver() {
        val notificationActionFilters = IntentFilter()
        notificationActionFilters.addAction(ACTION_UPDATE_NOTIFICATION)
        notificationActionFilters.addAction(ACTION_DELETED_NOTIFICATIONS)
        requireActivity().registerReceiver(notificationReceiver, notificationActionFilters)
    }

    private fun setupUiButtonStates(
        enableNotify: Boolean,
        enableUpdate: Boolean,
        enableCancel: Boolean
    ) {
        notify.isEnabled = enableNotify
        update.isEnabled = enableUpdate
        cancel.isEnabled = enableCancel
    }

    private fun cancelNotification() {
        mNotifyManager.cancel(NOTIFICATION_ID)
        setupUiButtonStates(enableNotify = true, enableUpdate = false, enableCancel = false)
    }

    private fun updateNotification() {
        val androidImage = BitmapFactory.decodeResource(resources, R.drawable.ic_android)
        val notification = getNotificationBuilder()
            .setStyle(
                NotificationCompat.BigPictureStyle()
                    .bigPicture(androidImage)
                    .setBigContentTitle("Notification Updated!")
            )
        mNotifyManager.notify(NOTIFICATION_ID, notification.build())
        setupUiButtonStates(enableNotify = false, enableUpdate = false, enableCancel = true)
    }

    private fun sendNotification() {
        val notificationBuilder = getNotificationBuilder()

        // for broadcast receiver
        val updateActionFilter = Intent(ACTION_UPDATE_NOTIFICATION)
        val updateAction = PendingIntent.getBroadcast(
            requireContext(),
            NOTIFICATION_ID,
            updateActionFilter,
            PendingIntent.FLAG_ONE_SHOT
        )
        notificationBuilder.addAction(
            R.drawable.ic_update,
            "Update Notification",
            updateAction
        )
        // for broadcast receiver
        val deletedActionFilter = Intent(ACTION_DELETED_NOTIFICATIONS)
        val deletedAction = PendingIntent.getBroadcast(
            requireContext(),
            NOTIFICATION_ID,
            deletedActionFilter,
            PendingIntent.FLAG_ONE_SHOT
        )
        notificationBuilder.setDeleteIntent(deletedAction)

        mNotifyManager.notify(NOTIFICATION_ID, notificationBuilder.build())
        setupUiButtonStates(enableNotify = false, enableUpdate = true, enableCancel = true)
    }

    private fun createNotificationChannel() {
        mNotifyManager =
            requireActivity().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            // Create a NotificationChannel
            val notificationChannel = NotificationChannel(
                PRIMARY_CHANNEL_ID,
                "Mascot Notification", NotificationManager.IMPORTANCE_HIGH
            )
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.RED
            notificationChannel.enableVibration(true)
            notificationChannel.description = "Notification from Mascot"
            mNotifyManager.createNotificationChannel(notificationChannel)
        }
    }

    private fun getNotificationBuilder(): NotificationCompat.Builder {
        val notificationIntent = Intent(requireContext(), NotificationFragment::class.java)
        val notificationPendingIntent = PendingIntent.getActivity(
            requireContext(),
            NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT
        )
        return NotificationCompat.Builder(requireContext(), PRIMARY_CHANNEL_ID)
            .setContentTitle("You've been notified!")
            .setContentText("This is your notification text.")
            .setSmallIcon(R.drawable.ic_android)
            .setContentIntent(notificationPendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setAutoCancel(true)
    }

    // for broadcast receiver
    override fun onDestroy() {
        requireActivity().unregisterReceiver(notificationReceiver)
        super.onDestroy()
    }

    inner class NotificationReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            // Update the notification
            when (intent.action) {
                ACTION_UPDATE_NOTIFICATION -> updateNotification()
                ACTION_DELETED_NOTIFICATIONS -> setupUiButtonStates(
                    enableNotify = true,
                    enableUpdate = false,
                    enableCancel = false
                )
            }
        }
    }
}